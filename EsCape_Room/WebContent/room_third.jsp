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
function inputText(number, i) {

	var a = $("input[name=text]").val();

	$("input[name=text]").val(a + number);

	$("input:button").eq(i - 1).hide();

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
		<h1>LEVEL3</h1>
		

	</div>
	
	<form action="Controller.do" method="post">
	<input type="hidden" name="command" value="result3">
	<input type="hidden" name="snum" value="1">
	<input type="hidden" name="enum" value="10">
	<input type="hidden" name="text" id="input" readonly="readonly">
	<table>
		
		<tr>
				<td><input type="button" value="4"
					onclick="inputText(this.value,1)"></td>
				<td><input type="button" value="10"
					onclick="inputText(this.value,2)"></td>
				<td><input type="button" value="30"
					onclick="inputText(this.value,3)"></td>
				<td><input type="button" value="21"
					onclick="inputText(this.value,4)"></td>
				<td><input type="button" value="5"
					onclick="inputText(this.value,5)"></td>
			</tr>
			<tr>
				<td><input type="button" value="6"
					onclick="inputText(this.value,6)"></td>
				<td><input type="button" value="13"
					onclick="inputText(this.value,7)"></td>
				<td><input type="button" value="20"
					onclick="inputText(this.value,8)"></td>
				<td><input type="button" value="19"
					onclick="inputText(this.value,9)"></td>
				<td><input type="button" value="35"
					onclick="inputText(this.value,10)"></td>
			</tr>
			<tr>
				<td><input type="button" value="14"
					onclick="inputText(this.value,11)"></td>
				<td><input type="button" value="11"
					onclick="inputText(this.value,12)"></td>
				<td><input type="button" value="1"
					onclick="inputText(this.value,13)"></td>
				<td><input type="button" value="23"
					onclick="inputText(this.value,14)"></td>
				<td><input type="button" value="24"
					onclick="inputText(this.value,15)"></td>
			</tr>
			<tr>
				<td><input type="button" value="2"
					onclick="inputText(this.value,16)"></td>
				<td><input type="button" value="8"
					onclick="inputText(this.value,17)"></td>
				<td><input type="button" value="22"
					onclick="inputText(this.value,18)"></td>
				<td><input type="button" value="28"
					onclick="inputText(this.value,19)"></td>
				<td><input type="button" value="31"
					onclick="inputText(this.value,20)"></td>
			</tr>
			<tr>
				<td><input type="button" value="3"
					onclick="inputText(this.value,21)"></td>
				<td><input type="button" value="9"
					onclick="inputText(this.value,22)"></td>
				<td><input type="button" value="17"
					onclick="inputText(this.value,23)"></td>
				<td><input type="button" value="37"
					onclick="inputText(this.value,24)"></td>
				<td><input type="button" value="38"
					onclick="inputText(this.value,25)"></td>
			</tr>
			<tr>
				<td><input type="button" value="18"
					onclick="inputText(this.value,26)"></td>
				<td><input type="button" value="26"
					onclick="inputText(this.value,27)"></td>
				<td><input type="button" value="32"
					onclick="inputText(this.value,28)"></td>
				<td><input type="button" value="27"
					onclick="inputText(this.value,29)"></td>
				<td><input type="button" value="25"
					onclick="inputText(this.value,30)"></td>
			</tr>
			<tr>
				<td><input type="button" value="29"
					onclick="inputText(this.value,31)"></td>
				<td><input type="button" value="34"
					onclick="inputText(this.value,32)"></td>
				<td><input type="button" value="36"
					onclick="inputText(this.value,33)"></td>
				<td><input type="button" value="39"
					onclick="inputText(this.value,34)"></td>
				<td><input type="button" value="12"
					onclick="inputText(this.value,35)"></td>
			</tr>
			<tr>
				<td><input type="button" value="7"
					onclick="inputText(this.value,36)"></td>
				<td><input type="button" value="15"
					onclick="inputText(this.value,37)"></td>
				<td><input type="button" value="16"
					onclick="inputText(this.value,38)"></td>
				<td><input type="button" value="33"
					onclick="inputText(this.value,39)"></td>
				<td><input type="button" value="40"
					onclick="inputText(this.value,40)"></td>
			</tr>
			<tr>
				<td><input type="submit" value="입력"></td>
				<td><input type="button" value="리셋" onclick="reset1()"></td>

			</tr>


	</table>

</form>
</body>
</html>