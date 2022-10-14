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
<form action="addr_add.jsp" method="post">
<input type="text" name="id" placeholder="아이디 입력"><br>
<input type="password" name="pwd" placeholder="비밀번호 입력"><br>
<input type="text" name="name" placeholder="이름"><br>
<td>모드 선택</td>
<td>
<select name=gender >
	<option selected>관리자모드</option>
	<option>일반 회원 모드</option>
<input type="submit" value="회원가입">
<br>
</form>
</fieldset>
</body>
</html>