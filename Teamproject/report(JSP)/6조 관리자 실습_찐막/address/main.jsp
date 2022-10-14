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
		//application 객체 정보를 얻어서 값이 존재하는지를 확인
		Integer visitCnt = (Integer) application.getAttribute("visitCnt");
		//존재하지 않을 경우에는 방문자 수를 저장할 변수 생성
		if(visitCnt == null){
			application.setAttribute("visitCnt", 1);
		}
		else{
		//존재할 경우 방문자 수 증가
			if(session.isNew()){
			visitCnt++;
		// application 객체에 저장
			application.setAttribute("visitCnt", visitCnt);
			}
		}
	%>
	<H2 style="text-align:center">당신은 <%= application.getAttribute("visitCnt") %>번째 방문자입니다!</H2>
	<HR>
	<form style="text-align:center">
		<a href="loginForm.jsp"><input type="button" value="로그인하기" style="text-align:center; width:200px; height:50px"></a>
		<a href="addr_form.html"><input type="button" value="회원가입" style="text-align:center; width:200px; height:50px"></a>
	</form>
</body>
</html>