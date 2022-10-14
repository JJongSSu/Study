<%@page import="java.util.Calendar"%>
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
	Calendar cal = Calendar.getInstance();
	//month는 0~11까지 있어서 +1 해줘야 됨
	out.print(cal.get(Calendar.YEAR)+"년 "+cal.get(Calendar.MONTH)+1+"월 "+cal.get(Calendar.DATE)+"일");
%>
</body>
</html>