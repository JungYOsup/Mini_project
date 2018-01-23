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
table input {
	margin-left: 10px;
	width: 50px;
	height: 30px;
	text-align: center;
}

#input {
	margin-left: 12px;
	width: 175px;
	text-align: right;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	//결과값을 넣는 번호판
	function inputText(number,i) {

		var a = $("input[name=text]").val();

		$("input[name=text]").val(a + number);
		
		$("input:button").eq(i-1).hide();
				
	}
	
	
	
	//리셋버튼

	function reset1() {

		$("input:button").show();
		$("input[name=text]").val("");
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h2>LEVEL 2</h2>
</div>

	<form action="Controller.do" method="post">
		<input type="hidden" name="command" value="result2"> <input
			type="hidden" name="text" id="input" readonly="readonly"
			placeholder="비밀번호는 최대6개">
		<table>

			<tr>
				<td><input type="button" value="4"	onclick="inputText(this.value,1)"></td>
				<td><input type="button" value="20"	onclick="inputText(this.value,2)"></td>
				<td><input type="button" value="15"	onclick="inputText(this.value,3)"></td>
				<td><input type="button" value="14"	onclick="inputText(this.value,4)"></td>
			</tr>
			<tr>
				<td><input type="button" value="6"
					onclick="inputText(this.value,5)"></td>
				<td><input type="button" value="18"
					onclick="inputText(this.value,6)"></td>
				<td><input type="button" value="2"
					onclick="inputText(this.value,7)"></td>
				<td><input type="button" value="5"
					onclick="inputText(this.value,8)"></td>
			</tr>
			<tr>
				<td><input type="button" value="3"
					onclick="inputText(this.value,9)"></td>
				<td><input type="button" value="1"
					onclick="inputText(this.value,10)"></td>
				<td><input type="button" value="7"
					onclick="inputText(this.value,11)"></td>
				<td><input type="button" value="8"
					onclick="inputText(this.value,12)"></td>
			</tr>
			<tr>
				<td><input type="button" value="16"
					onclick="inputText(this.value,13)"></td>
				<td><input type="button" value="19"
					onclick="inputText(this.value,14)"></td>
				<td><input type="button" value="10"
					onclick="inputText(this.value,15)"></td>
				<td><input type="button" value="13"
					onclick="inputText(this.value,16)"></td>
			</tr>
			<tr>
				<td><input type="button" value="9"
					onclick="inputText(this.value,17)"></td>
				<td><input type="button" value="11"
					onclick="inputText(this.value,18)"></td>
				<td><input type="button" value="12"
					onclick="inputText(this.value,19)"></td>
				<td><input type="button" value="17"
					onclick="inputText(this.value,20)"></td>
			</tr>



			<tr>
				<td><input type="submit" value="입력"></td>
				<td><input type="button" value="리셋" onclick="reset1()"></td>

			</tr>



		</table>

	</form>
</body>
</html>