<!--- 페이지 디렉티브<%--  <%@page %> --%> : JSP페이지에 대한 설정 정보를 지정 -->
<!--인코딩은 UTF-8이고 , html이다.  -->
<!--이렇게 3가지를 구성해줘야지 한글이 안깨짐  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> HTML4버전     -->
<!DOCTYPE html>
<!--HTML5로 버전을 지정해줌 -->

<html>
<head>
<style type="text/css">


table input{
	
	margin-left:10px;
	width: 50px;
	height: 30px;
	text-align: center;
	
	
}
#input{
	margin-left:12px;
	width: 175px;
	text-align: right;
}

</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	
	
	//결과값을 넣는 번호판
	function inputText(number) {
		
		var a =$("input[name=text]").val();
	
		//결과값은 최대 6자리이다.
		if(a.length<6){
				
		$("input[name=text]").val(a+number);
	
		}
		
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="text" id="input" readonly="readonly" placeholder="비밀번호는 최대6개">
	<table>
		
		<tr>
			<td><input type="button" value="1" onclick="inputText(this.value)"></td>
			<td><input type="button" value="2" onclick="inputText(this.value)"></td>
			<td><input type="button" value="3" onclick="inputText(this.value)"></td>
		</tr>
		<tr>
			<td><input type="button" value="4" onclick="inputText(this.value)"></td>
			<td><input type="button" value="5" onclick="inputText(this.value)"></td>
			<td><input type="button" value="6" onclick="inputText(this.value)"></td>
		</tr>
		<tr>
			<td><input type="button" value="7" onclick="inputText(this.value)"></td>
			<td><input type="button" value="8" onclick="inputText(this.value)"></td>
			<td><input type="button" value="9" onclick="inputText(this.value)"></td>
		</tr>




	</table>

</body>
</html>