<%@page import="model.MemberVO"%>
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
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp");
		}
	
		String name = member.getName();
	%>
	<%= name %>님 환영합니다.
	<a href="allSelect">회원 목록 보기</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>