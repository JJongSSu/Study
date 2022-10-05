<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 만들기</title>
</head>
<body>
<!-- html으로 출력 -->
<table border>
<tr>
<%
for (int i=1;i<=10;i++){
	out.print("<td>"+i+"</td>");
}
%>
</tr>
</table>

<%-- jsp 표현식으로 출력 
	<%= %> => out.print와 동일
--%>
<table border>
<tr>
<% for(int i=1;i<=10;i++){%>
	<td><%=i %></td>
<%}%>
</tr>
</table>


</body>
</html>