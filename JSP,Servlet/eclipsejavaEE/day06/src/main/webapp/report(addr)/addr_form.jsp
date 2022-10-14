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
<legend>회원가입</legend>
<form action="addr_add.jsp" method="post">
<table>
<tr><td>아이디 : </td><td><input type="text" name="id" placeholder="아이디 입력"></td></tr>
<tr><td>비밀번호 : </td><td><input type="password" name="pwd" placeholder="비밀번호 입력"></td></tr>
<tr><td>이름 : </td><td><input type="text" name="username" placeholder="이름"></td></tr>
<tr><td>성별 : </td><td><input type="radio" name="gender" value="man">남자
	<input type="radio" name="gender" value="woman">여자</td></tr>
<tr><td>주소 : </td><td><input type="text" name="addr" placeholder="주소"></td></tr>
<tr><td>전화번호 : </td><td><input type="text" name="tel" placeholder="전화번호"></td></tr>
<tr><td><input type="submit" value="회원등록"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>