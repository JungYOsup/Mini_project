
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html> 

<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
<h1>상세보기</h1>
<form action="Controller.do" method="post">
<input type="hidden" name="command" value="detailform">
<table border="1" id="table1">

	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>기록</td>
		<td>날짜</td>
		<td>등급</td>
		<td>탈퇴여부</td>
		<td>버튼</td>
		
	</tr>
	
		
	<tr>
		<td>${dto.seq}</td>
		<td><input type="text" value="${dto.user_id}" name="id" readonly="readonly"></td>
		<td>${dto.user_name}</td>
		<td>${dto.email}</td>
		<td>${dto.user_record}</td>
		<td>${dto.sregdate}</td>
		<td>
		<select name="select"> 
		<option value="ADMIN" ${dto.grade=="ADMIN"?"selected":""}>관리자</option>
		<option value="GOLD" ${dto.grade=="GOLD"?"selected":""}>골드</option>
		<option value="SILVER" ${dto.grade=="SILVER"?"selected":""}>실버</option>
		<option value="BRONZE" ${dto.grade=="BRONZE"?"selected":""}>브론즈</option>
		</select> 
		</td>
		<td>
		<select name="select2"> 
		<option value="Y" ${dto.enabled=="Y"?"selected":""}>가입</option>
		<option value="N" ${dto.enabled=="N"?"selected":""}>탈퇴</option>
		</select> 
		</td>
		<td><input type="submit" value="수정하기"></td>
		
	</tr>
	
	
</table>
</form>
</body>
</html>