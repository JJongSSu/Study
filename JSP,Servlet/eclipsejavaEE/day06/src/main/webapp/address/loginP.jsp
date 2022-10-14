<%@page import="beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member member = new Member();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	String name = member.checkUser(id, pw);
	if(name != null){
		session.setAttribute("name", name);
		response.sendRedirect("login.jsp");
	}
	else{
		response.sendRedirect("loginForm.jsp");
	}
	
%>
</body>
</html>