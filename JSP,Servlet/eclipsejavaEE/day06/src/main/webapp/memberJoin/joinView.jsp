<%@page import="com.member.beans.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ml" class="com.member.beans.MemberManager" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입 결과</h3>

<jsp:useBean id="member" class="com.member.beans.Member" scope="session"/>
아이디 : <jsp:getProperty property="id" name="member"/><br>
비밀번호 : <jsp:getProperty property="pw" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/>
<h3>회원 리스트</h3>
<table>
<tr><th>아이디</th><th>비밀번호</th><th>이름</th></tr>
<%
	ArrayList<Member> mms = ml.getList();
	for(int i=0;i<mms.size();i++){
		Member m = mms.get(i);
%>		
		<tr>
		<td><%= m.getId() %></td>
		<td><%= m.getPw() %></td>
		<td><%= m.getName() %></td>
		</tr>
	<%} %>
</table>
</body>
</html>