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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	function check(id) {
		
		
		
		
		if (id =="") {
			
			$("span[id=sp]").text("아이디를 입력해주세요.");

		} else {
			
					
			
		$.ajax({
			
				url : "AjaxController.do",
				data : "id=" + id,
				type : "post",
				datatype : "json",
				success : function name(obj) {
					
					//json형태로 값이 전달받았다. 그렇기때문에 key로써 값을 찾을수 있다. 
					
					var dto = obj["dto"];

					if (dto==null) {//데이터베이스에 아이디가 없을 경우

						$("span[id=sp]").text("사용가능한 아이디입니다.");
						$("input[name=isS]").val("Y");
						$("input[name=pw]").focus();
					} else {

						$("span[id=sp]").text("이미존재하는 아이디입니다.");
						$("input[name=isS]").val("N");
						$("input[id=idchk]").val("");

					}

				}

			});
			
		}

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller.do" method="post">
		<input type="hidden" name="command" value="signup">
		<input type="hidden" value="N" name="isS">
		<table border="1">
			<tr>

				<td>아이디</td>
				<td><input type="text" name="id" id="idchk" required="required" ></td>
				<td><input type="button" value="중복확인" onclick="check(idchk.value)" ><span id="sp"></span></td>

			</tr>

			<tr>

				<td>비밀번호</td>
				<td><input type="text" name="pw" required="required"></td>
			</tr>
			<tr>

				<td>이름</td>
				<td><input type="text" name="name" id="a" required="required"></td>
			</tr>
			<tr>

				<td>이메일</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="회원등록"/></td>
				<td><input type="button" value="취소" onclick="location.href='Controller.do?command=loginform'"></td>

			</tr>

		</table>
	</form>
</body>
</html>