<%@page import="beans.Member"%>
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
	//request 객체로부터 data 가져오기
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");

	// Member 객체 생성 후 data 저장
	// 객체 생성, getter, setter를 해야하는 과정이 많이 때문에 action을 이용
//	Member member = new Member();
//	member.setId(id);
//	member.setPw(pw);
//	member.setName(name);
	//session.setAttribute("member", member);
//	request.setAttribute("member", member);
//	RequestDispatcher dispt = request.getRequestDispatcher("joinView.jsp");	// data를 넘겨주기 위해 선언
//	dispt.forward(request, response);	
	// 해당 페이지에서 발생되는 data를 request.set을 통해 넘겨줌
	// 받는 페이지에서는 request.get을 통해 data를 받음
	// sendDireect : url로 data를 이동시킴
%>
	
<!-- userBean 이용한 객체 생성과 data 저장 -> action 태그는 XML 표준에 맞추어 작성-->
<jsp:useBean id="member" class="beans.Member" scope="request" />
<jsp:setProperty property="*" name="member"/>
<!-- 
<jsp:setProperty property="id" name="member"/>
<jsp:setProperty property="pw" name="member"/>
<jsp:setProperty property="name" name="member"/>
 -->
<%
	RequestDispatcher dispt = request.getRequestDispatcher("joinView.jsp");	// data를 넘겨주기 위해 선언
	dispt.forward(request, response);
%>
	
<!--  dispatcher를 사용해서 다른페이지로 넘어가기 때문에 html이 필요 없음
<h3>회원가입 결과</h3>
아이디 : <=member.getId() %><br>
비밀번호 : <=member.getPw() %><br>
이름 : <=member.getName() %>
-->
</body>
</html>