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
	String name = (String)request.getAttribute("name");	// return type이 Object이기 때문에 String으로 변환해줘야 됨
%>
<%=name%>님 환영합니다.

<a href="login.html">로그아웃</a>
</body>
</html>