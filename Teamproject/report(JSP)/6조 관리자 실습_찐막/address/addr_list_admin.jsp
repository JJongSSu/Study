<%@page import="com.addr.app.AddrManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.addr.app.*"%>
<!DOCTYPE html>
<jsp:useBean id="am" class="com.addr.app.AddrManager" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
<div align=center>
<H2>회원 목록</H2>
<HR>
<a href="addr_form.html">회원정보 추가</a><p><a href="main.jsp">로그아웃</a><P>
<table border=1 width=600>
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>전화번호</td><td>이메일</td><td>성별</td><td>관리자</td></tr>
<%
	for(AddrBean ab : am.getAddrList()) {
%>
	<tr>
	<td><%=ab.getUserid() %></td>
	<td><%=ab.getUserpwd() %></td>
	<td><%=ab.getUsername() %></td>
	<td><%=ab.getTel() %></td>
	<td><%=ab.getEmail() %></td>
	<td><%=ab.getGender() %></td>
	<td><%=ab.isGrade() %></td></tr>
	
<%	
	}
%>
</table>
</div>
</body>
</html>


