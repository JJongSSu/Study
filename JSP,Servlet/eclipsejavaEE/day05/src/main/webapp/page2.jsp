<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1페이지</h2>
<%=session.getAttribute("userId") %>님 환영합니다.
<%
	if(session.getAttribute("userId") == null){
		response.sendRedirect("loginForm.jsp");
	}
%>
<br><br>
<a href = "page1.jsp">1페이지로 이동</a>
</body>
</html>