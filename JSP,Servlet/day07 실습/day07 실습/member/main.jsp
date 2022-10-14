<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset style="text-align:center">
<legend>메인페이지</legend>
	<a href="join.jsp">회원가입</a><p>
	<a href="login.jsp">로그인</a>
</fieldset>

	<%
		String message = (String) request.getAttribute("message");
		if(message!=null){
			out.print(message);
		}
		%>

</body>
</html>