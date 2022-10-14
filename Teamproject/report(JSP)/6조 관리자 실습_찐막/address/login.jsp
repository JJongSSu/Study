<%@page import="com.addr.app.AddrBean"%>
<%@page import="com.addr.app.AddrManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="am" class="com.addr.app.AddrManager" scope="application"/>
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
			System.out.print(ab2.isGrade());
		}
				
 		if(ab != null){
			if(ab.isGrade()==true && pwd.equals(ab.getUserpwd())){
				response.sendRedirect("addr_list_admin.jsp");
				
			}
			else if(id.equals(ab.getUserid()) && pwd.equals(ab.getUserpwd())){
				response.sendRedirect("addr_list_member.jsp");
			}
			else {
				response.sendRedirect("loginForm.jsp");
			}
		}
		else {
			response.sendRedirect("loginForm.jsp");
		}
	
	%>
</body>
</html>