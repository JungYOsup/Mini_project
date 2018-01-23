<%@page import="java.util.List"%>
<%@page import="min.edu.dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> HTML4버전     --> 
<!DOCTYPE html> <!--HTML5로 버전을 지정해줌 -->

<html>
<head>
<style type="text/css">

#myresult{

	margin-top: 50px;
	height: 50px;
	width: 328px;

}



</style>

<%


	Dto ldto = (Dto)session.getAttribute("ldto"); //session에서 받아올때는 object로 받아오기때문에 형변환을 해줘야한다.(나의 기록을 보여주는 역할)
	
	List<Dto> lists= (List<Dto>)request.getAttribute("lists");/* request.getAttribute()는 객체를 받을때 쓴다.(전체기록을 받아주는 역할) */
	/*request.getParameterValues(arg0) 는 리턴타입이 String[]타입 즉 String배열을 받을때 쓴다.*/
	//전체데이터를 가지고 와서 보여주고 , 나의기록도 보여주고 확인을 눌렀을때 나의 기록이 저장되게끔. 
	
	Long start =(Long)session.getAttribute("start");	
	Long end = (Long)session.getAttribute("end");
	
	Integer pg = (Integer)request.getAttribute("page");
	out.print(start);
	out.print(end);
	
	String result =( end - start )/1000.0+""; 
	
	
			
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>랭킹</td>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>기록</td>
		<td>날짜</td>
	</tr>
	
	
	
	<!--c:choose 에서  무조건 when 과 otherwise를 같이 써줘야아한다 ! 둘중 하나만 쓸경우 기능이 동작을 안한다  -->
	
	<c:forEach var="i" items="${lists}">
	
	<tr>
		<td>${i.rank}</td>
		<td>${i.seq}</td>
		<td>${i.user_id}</td>
		<td>${i.user_name}</td>
		<td>${i.user_record}</td>
		<td>${i.regdate}</td>
	</tr>
	
	
	<c:if test="${i.rank==5}">
		
		<tr><td colspan="6">---------------------1~5위까지(Gold)--------------------</td></tr>
	
	</c:if>
	
	
	<c:if test="${i.rank==20}">
		
		<tr><td colspan="6">---------------------5~20위까지(Silver)--------------------</td></tr>
	
	</c:if>
	
	
	</c:forEach>
	
	<tr>
	<td colspan="4" style="text-align:center;">
	
	<%
		for(int i=0; i<pg; i++){
			
			%>
			
			<a class="pageNum" href="Controller.do?command=result3&snum=<%=i<1?"1":i+"1"%>&enum=<%=i<1?"10": (i+1)+"0"%>"><%=i+1 %></a>
			<%
		}
	
	
	
	%>
		
	
	
	</td>
	
	
	
	</tr>	
	

	
</table>
	
<table border="1" id="myresult">

		
	<tr><td colspan="5">나의기록</td><tr>
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>기록</td>
		<td>날짜</td>
	
	</tr>
	
	
	<tr>	
		
		<td>${ldto.seq}</td>
		<td>${ldto.user_id}</td>
		<td>${ldto.user_name}</td>
		<td><%=result %>초</td>
		<td>${ldto.regdate}</td>
	</tr>
	
	<tr>
		<td><input type="button" value="등록" onclick="location.href='Controller.do?command=update&result=<%=result%>&id=<%=ldto.getUser_id()%>'"></td>
		<td><input type="button" value="취소" onclick="location.href ='Controller.do?command=loginform'"></td>
	</tr>
	

</table>
</body>
</html>