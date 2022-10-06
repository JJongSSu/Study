<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	String[] array = {"smart","asdf"};
	out.print(Arrays.asList(array).contains("smart"));
	
	if(id.equals("smart") && pw.equals("1234")){
		// sendRedirect 이용한 페이지 이동 -> 정보를 얻기 위해서는 2번 이동 시켜야 됨
		//								(연결되어 있는 페이지에만 정보 이동 가능)
		// response.sendRedirect("loginsuccess.jsp?id="+id);
		
		//forward 이용한 페이지 이동 -> 정보를 1번만 이동
		String name = "홍길동";
		request.setAttribute("name", name);
		RequestDispatcher dispt = request.getRequestDispatcher("loginsuccess.jsp");
		dispt.forward(request, response);
	}
	else{
		// sendRedirect 이용한 페이지 이동
		response.sendRedirect("loginfail.jsp");
	}
%>
</body>
</html>