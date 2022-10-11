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
	request.setCharacterEncoding("utf-8");
	String[] books = request.getParameterValues("book");
	Cookie[] cookies = new Cookie[books.length];
	for (int i=0;i<books.length;i++){
		cookies[i] = new Cookie("book"+i, books[i]);
		cookies[i].setMaxAge(60*60);
		response.addCookie(cookies[i]);
	}
	response.sendRedirect("shoppingBook.jsp");	// 담은 정보를 다시 보내줌
%>
</body>
</html>