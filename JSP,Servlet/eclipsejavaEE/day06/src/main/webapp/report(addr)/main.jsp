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
	Integer visitCnt =(Integer)application.getAttribute("visitCnt");
	if(visitCnt == null){
		application.setAttribute("visitCnt", 1);
	}
	else{
		if(session.isNew()){
			visitCnt++;
			application.setAttribute("visitCnt", visitCnt);
		}
		System.out.println("최초 방문: "+ visitCnt);
	}
%>
당신은<%=application.getAttribute("visitCnt") %>번째 방문자 입니다.
<form method="post">
<button type="button" onclick="location.href='login_form.jsp' ">로그인</button>
<button type="button" onclick="location.href='addr_form.jsp' ">회원가입</button>
<br>
</form>
</body>
</html>