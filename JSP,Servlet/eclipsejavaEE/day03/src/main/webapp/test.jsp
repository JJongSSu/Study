<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방 만들기</h3>
<table border>
<tr>
<%
	String room = request.getParameter("room");
	int num = Integer.parseInt(request.getParameter("num"));
	
	out.print(room);
	for (int i=1;i<=num;i++){
		out.print("<td>"+i+"</td>");
	}
%>
</tr>
</table>
</body>
</html>