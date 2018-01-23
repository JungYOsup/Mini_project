<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html> 

<!--jquery 라이브러리 사용!  -->
<html>
<head>
<script type="text/javascript" src="__jquery.tablesorter/jquery-latest.js"></script> 
<script type="text/javascript" src="__jquery.tablesorter/jquery.tablesorter.js"></script> 
<link rel="stylesheet" href="__jquery.tablesorter/themes/blue/style.css" type="text/css">
<link rel="stylesheet" href="__jquery.tablesorter/themes/green/style.css" type="text/css">

<script type="text/javascript">

$(document).ready(function(){ 
	$("#myTable").tablesorter();
}); 





</script>

<style type="text/css">

th.headerSortUp { 
    background-image: url(asc.gif); 
    background-color: #3399FF; 
} 

th.headerSortDown { 
    background-image: url(desc.gif); 
    background-color: #3399FF; 
} 

th.header { 
    background-image: url(img/bg.gif); 
    cursor: pointer; 
    font-weight: bold; 
    background-repeat: no-repeat; 
    background-position: center left; 
    padding-left: 20px; 
    border-right: 1px solid #dad9c7; 
    margin-left: -1px; 
} 

</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	
<h1>전체회원정보</h1>

<table border="1" id="myTable" class="tablesorter">
	
 	<thead>
	<tr>
		<th>랭킹</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일 </th>
		<th>기록 </th>
		<th>날짜 </th>
		<th>등급 </th>
		<th>탈퇴여부 </th>
	</tr>
	</thead>
	
	<tbody>
	<c:choose>
	
	<c:when test="${empty lists}"> 
	
	<tr>
	<td colspan="8">--------아무 회원도 존재하지 않습니다.--------</td>
	</tr>
	
	
	</c:when>
	</c:choose>
	
	<c:forEach var="i" items="${lists}">
	<tr>
		
		<td>${i.rank}</td>
		<td><a href="Controller.do?command=selectdetail&id=${i.user_id}">${i.user_id}</a></td>
		<td>${i.user_name}</td>
		<td>${i.email}</td>
		<td>${i.user_record}</td>
		<td>${i.regdate}</td>
		<td>${i.grade}</td>
		<td>${i.enabled}</td>
	</tr>
	</c:forEach>	
	</tbody>
	
</table>




</body>
</html>