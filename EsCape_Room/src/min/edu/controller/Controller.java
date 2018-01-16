package min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import min.edu.dao.Dao;
import min.edu.dto.Dto;

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

		if(command.equals("loginform")){

			response.sendRedirect("login_form.jsp");

		}else if(command.equals("adminform")) {

			response.sendRedirect("adminform.jsp");

		}else if(command.equals("selectAll")) {

			List<Dto> lists = dao.selectAll();
			request.setAttribute("lists", lists);
			dispatch("Controller.do?command=loginform", request, response);

		}else if(command.equals("selectdetail")) {

			Dto dto = null;
			String id = request.getParameter("id");
			dto = dao.selectdetail(id);


		}else if(command.equals("login")) {

			Dto ldto = null;
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			ldto = dao.login(id, pw);
			if(ldto!=null) { //ldto가 있으면 , 처음에는 ldto.getid()로써 가져와서 해보렿 했으나 쿼리문에서 정보가 없어 null을 보낼때 null.getid()를 할수가 없으므로, else에서 nullpointException이 뜬다.
				//따라서 ldto!=null로 바꿔줌

				request.getSession().setAttribute("ldto", ldto);
				request.getSession().setMaxInactiveInterval(10*60);


				if(ldto.getGrade().toUpperCase().equals("ADMIN")) {

					response.sendRedirect("Controller.do?command=adminform");

				}else if(ldto.getGrade().equals("USER")) {

					response.sendRedirect("room_first.jsp");

				}
			}else {

				response.sendRedirect("Controller.do?command=loginform");
			}


		}else if(command.equals("signup")) {

			String id =request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");


			boolean isc =dao.signup(id, pw, name, email);

			if(isc) {

				response.sendRedirect("Controller.do?command=loginform");

			}else {

				response.sendRedirect("Controller.do?command=signup");
			}

		}else if(command.equals("check")) {
		
					
						
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
