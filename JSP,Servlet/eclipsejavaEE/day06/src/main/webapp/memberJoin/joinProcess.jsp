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
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.member.beans.Member"/> 
<jsp:setProperty property="*" name="member"/>
<%
	ml.add(member);
	session.setAttribute("member", member);
	// response.sendRedirect("joinView.jsp");
%>
<a href="joinView.jsp">회원정보 보기</a><br>
</body>
</html>