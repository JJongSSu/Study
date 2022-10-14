<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사이트 방문자 수 출력하기 : application 객체 이용</h3>
<%
	// application 객체 정보를 얻어서 값이 존재하는지 확인(없을 경우 저장할 변수 생성)
	Integer visitCnt = (Integer) application.getAttribute("visitCnt");
	if(visitCnt == null){
		application.setAttribute("visitCnt", 1);
	}
	else{
		// 방문자수가 로그인하고 나서 다시 그 사이트로 돌아왔을 때는 증가 x
		// 새로 로그인하면 +1 -> 로그인할 때 새로운 session 부여
		if(session.isNew()){
			visitCnt += 1;
			application.setAttribute("visitCnt", visitCnt);
		}
	}
%>
방문자수 : <%=application.getAttribute("visitCnt") %>명
</body>
</html>