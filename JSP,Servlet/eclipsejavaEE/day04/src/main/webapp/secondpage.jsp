<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 600px; height: 500px; border: 1px solid gray; text-align: center">
<h2>두번째 페이지</h2>
내용이 여기에 들어갑니다.
<p><img src="./images/picture1.jpg" style="width:400px; height:300px;">
<hr>
<a href="firstpage.jsp">첫번째 페이지로 이동</a>
<hr>
오늘 날짜 : <%@ include file="today.jsp" %>
<hr>
<a href="test03.html">로그아웃</a>
</div>
</body>
</html>