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
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pw2 = request.getParameter("pw2");
	String gender = request.getParameter("gender");
	String blood = request.getParameter("blood");
	String brithday = request.getParameter("brithday");
	String[] hobby = request.getParameterValues("hobby");
	String firstcolor = request.getParameter("firstcolor");
	String write = request.getParameter("write");

	out.print("아이디 : "+id+"<br>");
	out.print("비밀번호 : "+pw+"<br>");
	if(!pw2.equals(pw)) {
		out.print("비밀번호가 일치하지 않습니다. <br>");
	}
	out.print("성별 : " + gender + "<br>");
	out.print("혈액형 : " + blood + "<br>");
	out.print("생일 : " + brithday + "<br>");
	out.print("취미 : ");
	for (int i=0;i<hobby.length;i++) {
		out.print(hobby[i]);
		if (i < hobby.length-1) {
			out.print(", ");
		}
		else {
			continue;
		}
	}
	out.print("좋아하는색  : " + firstcolor + "<br>");
	out.print("<div style='width:100px;height:100px;background:"+firstcolor+";'></div>");
	out.print("남기고 싶은 말 : " + write + "<br>");
%>
</body>
</html>