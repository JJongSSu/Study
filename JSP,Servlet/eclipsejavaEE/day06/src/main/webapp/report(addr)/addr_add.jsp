<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="report.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="addr" class="report.AddrBean"/>
<jsp:setProperty name="addr" property="*"/>

<jsp:useBean id="am" class="report.AddrManager" scope="application"/>
<%
	am.add(addr);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addr_add.jsp</title>
</head>
<body>
<div align="center">
<H2>등록내용</H2>
아이디 : <jsp:getProperty property="id" name="addr"/><P>
비밀번호 : <%=addr.getpwd() %><P>
이름 : <%=addr.getUsername() %> <P>
성별 : <%=addr.getGender() %> <p>
주소 : <%=addr.getAddr() %> <p>
전화번호 : <%=addr.getTel() %>
<HR>
<a href="login_form.jsp">로그아웃</a>
</div>
</body>
</html>






