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
	// 로그인 정보를 가져와서 사이트 사용자 확인
	String userId = "smart";
	String userPw = "1234"; 
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals(userId) && pw.equals(userPw)){
		session.setAttribute("userId", userId);	// 세션정보로 userId 값 저장
		long sessionStartTime = session.getCreationTime();	// 1970.1.1 기준으로 시작시점 계산(1/1000 초단위)
		session.setAttribute("sst", sessionStartTime/1000);
		response.sendRedirect("(bank)page1.jsp");
	}
	else{
		response.sendRedirect("(bank)loginForm.jsp");
		out.print("잘못 입력하셨습니다.");
	}
%>
</body>
</html>