<%@page import="report.AddrBean"%>
<%@page import="report.AddrManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="am" class="report.AddrManager" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	AddrBean ab = am.getAddr(id);
	
	for(AddrBean ab2 : am.getAddrList()) {
		System.out.print(ab2.getGrade());
	}
			
	if(ab != null){
		if(Integer.parseInt(ab.getGrade())==1 && pwd.equals(ab.getpwd())){
			response.sendRedirect("addr_list.jsp");
		}
		else if(id.equals(ab.getid()) && pwd.equals(ab.getpwd())){
			response.sendRedirect("addr_list_member.jsp");
		}
		else {
			response.sendRedirect("login_form.jsp");
		}
	}
	else {
		response.sendRedirect("login_form.jsp");
	}
	
%>
</body>
</html>