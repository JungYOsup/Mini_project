<!--- 페이지 디렉티브<%--  <%@page %> --%> : JSP페이지에 대한 설정 정보를 지정 -->
<!--인코딩은 UTF-8이고 , html이다.  -->
<!--이렇게 3가지를 구성해줘야지 한글이 안깨짐  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> HTML4버전     --> 
<!DOCTYPE html> <!--HTML5로 버전을 지정해줌 -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인화면</h2>
<form action="Controller.do" method="post">
<input type="hidden" name="command" value="login">
<table border="1">

	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
				
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="로그인"> </td>
		<td><input type="button" value="회원가입" onclick="location.href='sign_up_form.jsp'"> </td>
		
	</tr>
</table>
</form>

</body>
</html>