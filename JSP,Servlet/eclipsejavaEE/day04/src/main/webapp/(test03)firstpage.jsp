<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 600px; height: 500px; border: 1px solid gray; text-align: center">
<h2>첫번째 페이지</h2>
<%
	String id = (String)session.getAttribute("id");
	if(session.getAttribute("id") == null){
		response.sendRedirect("test03.html");
	}
%>
<%=id%>님 환영합니다.
<p><img src="./images/picture2.jpg" style="width:400px; height:300px;">
<hr>
<a href="(test03)secondpage.jsp">두번째 페이지로 이동</a>
<hr>
<!--  오늘 날짜 : %@ include file="today.jsp" % -->
<!-- file 간의 연결은 로딩시간이 있기 때문에 가능하면 해당 file 안의 코드를 가져와서 직접 사용하는게 좋음 -->
<%
	Calendar cal = Calendar.getInstance();
	//month는 0~11까지 있어서 +1 해줘야 됨
	out.print(cal.get(Calendar.YEAR)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일");
%>
<hr>
<a href="(test03)logout.jsp">로그아웃</a>
</div>
</body>
</html>