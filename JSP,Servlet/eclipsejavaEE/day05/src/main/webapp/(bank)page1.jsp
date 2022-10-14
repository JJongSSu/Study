<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1페이지</h2>
<%=session.getAttribute("userId") %>님 환영합니다.
<%
	// 회원정보가 null 값이면 로그인 화면으로 가도록 만들어 줘야 됨
	// 안해주면 url 주소 복사해서 브라우저로 들어가보면 null님 환영합니다로 뜨게 됨
	if(session.getAttribute("userId") == null){
		response.sendRedirect("loginForm.jsp");
	}
%>
<br><br>
<a href = "page2.jsp">2페이지로 이동</a>
</body>
</html>