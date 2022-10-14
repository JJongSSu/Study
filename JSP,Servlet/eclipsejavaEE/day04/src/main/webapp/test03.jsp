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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("smart") && pw.equals("1234")){
		session.setAttribute("id", id);
		RequestDispatcher dispt = request.getRequestDispatcher("(test03)firstpage.jsp");
		dispt.forward(request, response);
	}
	else{
		response.sendRedirect("test03.html");
	}
%>
</body>
</html>