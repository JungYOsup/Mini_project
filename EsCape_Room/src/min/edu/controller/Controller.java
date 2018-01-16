package min.edu.controller;

import java.io.IOException;
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
		
		String command = request.getParameter("command");
		Dao dao = new Dao();
		if(command.equals("loginform")){
			
			response.sendRedirect("login_form.jsp");
		
		}else if(command.equals("adminform")) {

			response.sendRedirect("adminform.jsp");
			
		}else if(command.equals("selectAll")) {
			
			List<Dto> lists = dao.selectAll();
			request.setAttribute("lists", lists);
			RequestDispatcher dispatch = request.getRequestDispatcher("");
			dispatch.forward(request, response);
		}else if(command.equals("selectdetail")) {
			
			Dto dto = null;
			String id = request.getParameter("id");
			dto = dao.selectdetail(id);
			
			
			
		}else if(command.equals("login")) {
			
			Dto ldto = null;
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			ldto = dao.login(id, pw);
			if(ldto.getUser_id()!=null) { //즉 아이디가 있다면
				
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
			
			
		}
		
				
	}

}
