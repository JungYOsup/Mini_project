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
<h2>제목</h2>
<div>
당신은 세계를 누비는 탐험가! 마지막 목표는 이집트의 피라미드!

엄청난 보물의 근원지를 파악했다는 정보를 입수햇다. 화려한 여행의 마무리를 
짖시 위해서 가족과 연인을 동반해서 탐험에 나섰다! 불가사의한 피라미드를 탐험 중 당신과 일행은 
피라미드에 갇히게 된다. 방안에 모든 단서를 이용하여피라미드를 탈출해야한다.
</div>
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