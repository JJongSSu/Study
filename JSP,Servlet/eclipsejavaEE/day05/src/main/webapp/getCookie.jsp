<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 정보 가져오기</h3>
<%
	// 시간 설정한 쿠키들은 시간이 지나면 없어짐
	Cookie[] cookies = request.getCookies();
	System.out.print("쿠키 갯수 : "+cookies.length);	//쿠키 갯수 확인(디버깅)
	
	// 쿠키 data 보여주기
	for(int i=0;i<cookies.length;i++){
		// 쿠키 data는 (name, value)로 존재
		String name = cookies[i].getName();
		String value = cookies[i].getValue();
		out.print(name+" : "+value+"<br>");
	}
%>
</body>
</html>