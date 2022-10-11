<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠기 생성 과정</h3>
<%
	//cookie가 달라지는 것 확인할 때 모든 창을 닫고 새로운 창을 열어서 확인
//	Cookie cookieId = new Cookie("id","smart");
//	Cookie cookieName = new Cookie("name","Lee");
//	Cookie cookieAge = new Cookie("age","28");
	
//	cookieId.setMaxAge(60*30);	// 쿠키 정보 유지 기간 설정(초단위) -> 30분 설정, 0으로 설정하면 브라우저 닫는 순간 사라짐(expires)
//	cookieName.setMaxAge(60*30);
//	cookieAge.setMaxAge(60*30);
	
//	response.addCookie(cookieId);	//클라이언트에 쿠키 전송
//	response.addCookie(cookieName);
//	response.addCookie(cookieAge);
	
	Cookie[] cookies = new Cookie[3];	//배열로 생성
	String[] name = {"id","name","age"};
	String[] value = {"smart","Lee","28"};
	// 쿠키 생성하면서 배열에 저장
	for(int i=0;i<cookies.length;i++){
		cookies[i] = new Cookie(name[i],value[i]);
		cookies[i].setMaxAge(60*30);
		response.addCookie(cookies[i]);
	}
%>
</body>
</html>