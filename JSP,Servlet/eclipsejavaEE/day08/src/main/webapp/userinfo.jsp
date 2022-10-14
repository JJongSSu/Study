<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	<!-- server lib에 설치해줘야 사용 가능 -->
<fmt:requestEncoding value="UTF-8"/>	<!-- < request.setCharacterEncoding("utf-8");%>와 같은 기능 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<style>
td {text-align:center;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>사용자 정보</legend>
<table style="width:400px; border:1px solid gray">
<tr><th>이름</th><th>나이</th><th>성별</th><th>좋아하는 음식</th><th>관심분야</th></tr>
<tr><td>${param.name }</td><td>${param.age }</td><td>${param.gender }</td><td>${param.food }</td>
<td> <c:forEach var="interest" items="${paramValues.interest }"> ${interest } </c:forEach></td></tr>
</table>
</fieldset>
</body>
</html>