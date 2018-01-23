package min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import min.edu.dao.Dao;
import min.edu.dto.Dto;
import min.edu.util.Util;

@WebServlet("/Controller.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 
		
		String command = request.getParameter("command");
		Dao dao = new Dao();
		
		//로그인이동
		if(command.equals("loginform")){
			
			Util.start=0;
			Util.end=0;
			
			response.sendRedirect("login_form.jsp");
		//관리자페이지로 이동	
		}else if(command.equals("adminform")) {

			response.sendRedirect("admin_form.jsp");
		//모든정보	
		}else if(command.equals("selectAll")) {
			
			List<Dto> lists = dao.selectAll();
			request.setAttribute("lists", lists);//그런데 지금 get방식으 형태로 전달하고 있기때문에 받는 곳에서
			dispatch("AllUser_form.jsp", request, response);
		//상세정보	
		}else if(command.equals("selectdetail")) {
			Dto dto = null;
			String id = request.getParameter("id");
			dto = dao.selectdetail(id);
			
			request.setAttribute("dto", dto);
			dispatch("DetailUser_form.jsp", request, response);
		//로그인	
		}else if(command.equals("login")) {

			Dto ldto = null;
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			ldto = dao.login(id, pw);
			if(ldto!=null) { //ldto가 있으면 , 처음에는 ldto.getid()로써 가져와서 해보렿 했으나 쿼리문에서 정보가 없어 null을 보낼때 null.getid()를 할수가 없으므로, else에서 nullpointException이 뜬다.
				//따라서 ldto!=null로 바꿔줌

				request.getSession().setAttribute("ldto", ldto); //jsp에서는 session.setAttribute지만 ,jsp에서는 request에서 session을 요청받아야한다
				//따라서 request.getSession().setAttribute();
				request.getSession().setMaxInactiveInterval(10*60);


				if(ldto.getGrade().toUpperCase().equals("ADMIN")) {

					response.sendRedirect("Controller.do?command=adminform");

				}else if(ldto.getGrade().toUpperCase().equals("BRONZE")||ldto.getGrade().toUpperCase().equals("SILVER")||ldto.getGrade().toUpperCase().equals("GOLD")) {
					
					long start = Util.getInstance2();
					
					System.out.println(start);
					
					request.getSession().setAttribute("start",start); //처음에 시작할때 시간을 잰값을 session에 담아둔다.
					
					response.sendRedirect("room_first.jsp");

				}
			}else {
							
				jsForward("아이디 또는 비밀번호가 틀립니다", "Controller.do?command=loginform", response);
			}

		//회원가입	
		}else if(command.equals("signup")) {
					
			String a = request.getParameter("isS");
			System.out.println(a);
			
			if(request.getParameter("isS").equals("Y")) {
				
				String id =request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				
				
				boolean isc =dao.signup(id, pw, name, email);
				
				if(isc) {
					jsForward("가입에 성공하셨습니다.", "Controller.do?command=loginform", response);
					
					
				}else {
					
					jsForward("가입에 실패하셨습니다.", "Controller.do?command=loginform", response);
				}
			}else {
				
				jsForward("중복확인을 눌러주세요", "sign_up_form.jsp", response);
				
			}
			
			
		//게임1단계	
		}else if(command.equals("result")) {
			String str="";
			String text = request.getParameter("text");
			
			System.out.println("입력받은값"+text);
			
			str=dao.bringresult(text);
			
			
			if(str!=null) {
				
				jsForward("성공", "room_second.jsp", response);
				
			}else {
				jsForward("실패", "room_first.jsp", response);
			}
		//게임2단계	
		}else if(command.equals("result2")) {
			String str="";
			String text = request.getParameter("text");
			
			System.out.println("입력받은값"+text);
			
			str=dao.bringresult(text);
			
			
			if(str!=null) {
				
				jsForward("성공", "room_third.jsp", response);
				
			}else {
				jsForward("실패", "room_second.jsp", response);
			}
		//게임3단계	
		}else if(command.equals("result3")) {
			
			String str="";
			String text = request.getParameter("text");
			List<Dto> lists = null;
			
			System.out.println("입력받은값"+text);
			
			str=dao.bringresult(text);
			
			
			//끝났을때 모든 기록값을 가지고와서 다음페이지에 뿌려준다.
			
			
			if(str!=null) {
				
				
				String sNum=request.getParameter("snum");
				
				String eNum=request.getParameter("enum");
				
				if(sNum==null) {
					sNum=(String)request.getSession().getAttribute("snum");
					eNum=(String)request.getSession().getAttribute("enum");
				}else {
					request.getSession().setAttribute("snum", sNum);
					request.getSession().setAttribute("enum", eNum);	
				}
						
				lists =dao.selectAll(sNum,eNum);
				int page = dao.pageCount();
				
				long end =Util.getInstance();
								
				request.getSession().setAttribute("end", end);
				request.setAttribute("lists", lists);
				request.setAttribute("page", page);
				
				//**이렇게 여러개를 보낼수도 있다!!
				dispatch("board_form.jsp", request, response);
				
				
				
								
			}else {
				jsForward("실패", "room_third.jsp", response);
			}
		//기록등록
		}else if(command.equals("update")) {
			
			String id = request.getParameter("id");
			String record = request.getParameter("result")+"초";
			
			boolean isc = dao.UpdateRecord(record,id);
			
			if(isc) {
				
				
				
				jsForward("기록이 등록되었습니다","Controller.do?command=loginform" , response);
				
				
			}else {
								
				jsForward("기록 등록 실패하셧습니다","Controller.do?command=loginform" , response);
			}
			
		//GRADE 업데이트 	
		}else if(command.equals("detailform")) {
				
				String grade =request.getParameter("select");
				String enabled =request.getParameter("select2");
				String id = request.getParameter("id");
				boolean isc = dao.UpdateGrade(grade,id,enabled);
				
				if(isc) {
					jsForward("수정되엇습니다","Controller.do?command=selectAll", response);
				}else {
					jsForward("수정실패","Controller.do?command=selectAll", response);
				}
		}



	}


	public void dispatch(String url,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	public void jsForward(String msg,String url,HttpServletResponse response) throws IOException{

		String str="<script type='text/javascript'>" //script type='text/javascript : 컴퓨터야 이 언어는 자바 스크립트야,자바스크립트로 해석해야해 ! 
				+ "alert('"+msg+"');"
				+ "location.href='"+url+"';"
				+ "</script>";

		PrintWriter pw = response.getWriter();//브라우저에 출력할 전용 프린터를 만든다.//프린터에 출력을 날리는 작업, java파일에서는 브라우저에 출력해줄수 있는게 없기 때문에 브라우저에 출력할 전용 프린터를 만들어야한다
		pw.print(str);//그렇기에 pw에 str파라미터로 넣어주고 그 값을 바로 출력할수 있도록 메서드 print를 쓰는것이다.
	}

}
