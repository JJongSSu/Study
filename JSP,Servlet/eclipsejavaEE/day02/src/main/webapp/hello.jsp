<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 스크립트릿 : JSP 문서 안에 java 코드를 넣을 때 사용 -->
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int sum = num + num1;
	out.println(num + "+" + num1 + "=" + sum);
%>
</body>
</html>