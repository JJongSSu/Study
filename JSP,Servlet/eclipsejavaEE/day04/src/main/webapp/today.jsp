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
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;	//month는 0~11까지 있어서 +1 해줘야 됨
	int day = cal.get(Calendar.DATE);
	
	out.print(year+"년 "+month+"월 "+day+"일");
%>
</body>
</html>