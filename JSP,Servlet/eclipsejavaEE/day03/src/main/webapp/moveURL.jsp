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
	String url = request.getParameter("url");
	
	if(url.equals("네이버")){
		response.sendRedirect("http://www.naver.com");
	}
	else if(url.equals("다음")){
		response.sendRedirect("https://www.daum.net/");
	}
	else if(url.equals("유튜브")){
		response.sendRedirect("https://www.youtube.com/");
	}
	else{
		response.sendRedirect("https://www.google.co.kr/");
	}	
%>
</body>
</html>