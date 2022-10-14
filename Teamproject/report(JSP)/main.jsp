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
//application 객체 정보를 얻어서 값이 존재하는 확인
	Integer visitCnt =(Integer)application.getAttribute("visitCnt");
// 존재하지 않을 경우에는 방문자 수를 저장할 변수 생성
	if(visitCnt == null){
	application.setAttribute("visitCnt", 1);
	}else{
//존재할 경우 방문자 수 증가
	if(session.isNew()){
	visitCnt++;
	//application 객체에 저장
	application.setAttribute("visitCnt", visitCnt);
		
	}
//출력문
	System.out.println("최초 방문: "+ visitCnt);

	}
%>
당신은<%=application.getAttribute("visitCnt") %>번째 방문자 입니다.
<fieldset>
<legend>로그인</legend>
<form action="loginP.jsp" method="post">
<input type="text" name="id" placeholder="아이디 입력"><br>
<input type="password" name="pwd" placeholder="비밀번호 입력"><br>
<input type="submit" value="회원가입">
<input type="submit" value="로그인">
<br>
</form>
</fieldset>
</body>

</body>
</html>