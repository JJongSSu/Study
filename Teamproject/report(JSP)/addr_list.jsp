<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align=center>
<H2>회원가입 목록</H2>
<HR>
<a href="addr_form.html">회원 추가</a><P>
<table border=1 width=500>
<tr><td>이름</td><td>아이디</td><td>비밀번호</td>
<%
	for(AddrBean ab : am.getAddrList()) {
%>
	<tr>
	<td><%=ab.getUsername() %></td>
	<td><%=ab.getId() %></td>
	<td><%=ab.getPwd() %></td>

<%	
	}
%>
</table>
</div>
</body>
</html>



</body>
</html>