<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>로그인</legend>
<form action="loginP.jsp" method="post">
<table>
<tr><td>아이디 : </td><td><input type="text" name="id" placeholder="아이디"></td></tr>
<tr><td>비밀번호 : </td><td><input type="password" name="pw" placeholder="비밀번호"></td></tr>
<tr><td></td><td><input type="submit" value="로그인"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>