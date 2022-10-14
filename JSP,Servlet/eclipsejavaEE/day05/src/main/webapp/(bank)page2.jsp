<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>2페이지</h2>
<%=session.getAttribute("userId") %>님 환영합니다.<br>
세션 시작 시간 : <%=session.getAttribute("sst") %><br>
세션 시간 다시 호출 : 
<%
	long presentTime = session.getLastAccessedTime()/1000;
	long stayTime = presentTime - (long)session.getAttribute("sst");
	out.print("사이트에 접속한 시간 : " + stayTime+"초");
%>
<%
	if(session.getAttribute("userId") == null){
		response.sendRedirect("(bank)loginForm.jsp");
	}
%>
<br><br>
<a href = "(bank)page1.jsp">1페이지로 이동</a><br><br>
<a href="(bank)logout.jsp">로그아웃</a>
</body>
</html>