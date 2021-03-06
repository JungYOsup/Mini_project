package min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import min.edu.dao.Dao;
import min.edu.dto.Dto;
import net.sf.json.JSONObject;

@WebServlet("/AjaxController.do")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		
		
		
		Dao dao  = new Dao();
		Dto dto = null;
		String id = request.getParameter("id");
		
		dto=dao.selectdetail(id);
		//Json은 Key,value형태이기 때문에 Map으로써 전달할수 있다.그렇기때문에 Map으로써 값을 넣은거임
		
		Map<String, Dto> map = new HashMap<String,Dto>();
		
		map.put("dto", dto);
		
		JSONObject obj = JSONObject.fromObject(map); //여기서 중요한것은 dto에서 DATE형식은 JSON형태로 바꿀수가 없다. 따라서 쿼리에서 DATE타입을 TO_CHAR형태로 바꿔줘야한다.
		
		PrintWriter pw = response.getWriter();
		
		obj.write(pw);
		
		
		
	}

}
