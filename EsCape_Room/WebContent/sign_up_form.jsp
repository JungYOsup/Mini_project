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

<table border="1">
	<tr>
	
	<td>아이디</td>
	<td><input type="text" name="id" ></td>
	<td><input type="button" value="중복확인"></td>
	</tr>
	<tr>
	
	<td>비밀번호</td>
	<td><input type="text" name="pw" ></td>
	</tr>
	<tr>
	
	<td>이름</td>
	<td><input type="text" name="name" ></td>
	</tr>
	<tr>
	
	<td>이메일</td>
	<td><input type="email" name="email" ></td>
	</tr>
	<tr>
		<td><input type="submit" value="회원등록"/></td>
		<td><input type="button" value="취소"> </td>
	
	</tr>
	
</table>

</body>
</html>