<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/webdb?"
		      +"useUnicode=true&characterEncoding=utf-8";
	String uid = "root";
	String pass = "tbrs00002b";
	String sql = "insert into member values(?, ?, ?, ?, ?, ?)";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입 성공</h3>
<a href="allMember.jsp"> 회원 전체 목록 보기 </a>
</body>
</html>