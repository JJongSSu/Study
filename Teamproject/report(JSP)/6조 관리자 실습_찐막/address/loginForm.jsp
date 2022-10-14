<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<fieldset style="width:300px; text-align:center">
		<legend>로그인</legend>
		<form action="login.jsp" method="post">
			아이디: <input type="text" name="id" placeholder="아이디를 입력하세요."><p>
			비밀번호: <input type="password" name="pwd" placeholder="비밀번호를 입력하세요."><p>
			<input type="submit" value="로그인">
			<a href="main.jsp"><input type="button" value="취소"></a>
		</form>
	</fieldset>
	
</div>
</body>
</html>