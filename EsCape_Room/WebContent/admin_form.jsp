<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Controller.do" method="post">
<input type="hidden" name="command" value="selectAll">

<input type="submit" value="모든 회원정보">
</form>


</body>
</html>