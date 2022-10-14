<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("name") %>님 환영합니다.
<input type="submit" value="회원가입">
<input type="submit" value="로그인">
</body>
</html>