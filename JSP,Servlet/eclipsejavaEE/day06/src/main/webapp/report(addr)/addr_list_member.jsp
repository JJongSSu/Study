<%@page import="report.AddrBean"%>
<%@page import="report.AddrManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="report.AddrManager.*"%>
<!DOCTYPE html>
<jsp:useBean id="am" class="report.AddrManager" scope="application"/>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align=center>
<H2>회원 목록</H2>
<HR>
<a href="main.jsp">로그아웃</a><P>
<table border=1 width=500>
<tr><td>이름</td><td>아이디</td><td>비밀번호</td><td>성별</td><td>등급</td><td>주소</td><td>전화번호</td>
<%
	for(AddrBean ab : am.getAddrList()) {
%>
	<tr>
	<td><%=ab.getUsername() %></td>
	<td><%=ab.getid() %></td>
	<td><%=ab.getpwd() %></td>
	<td><%=ab.getGender() %></td>
	<td><%=ab.getGrade() %></td>
	<td><%=ab.getAddr() %></td>
	<td><%=ab.getTel() %></td>
<%	
	}
%>
</table>
</div>
</body>
</html>