<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 장바구니</title>
<style>
	table {
	    width: 100%;
	    border-top: 1px solid #444444;
	    border-collapse: collapse;
  	}
	th, td {
	  border-bottom: 1px solid #444444;
	  padding: 10px;
	  text-align: center;
  	}
  	th:first-child, td:first-child {
    border-left: none;
  	}
</style>
</head>
<body>
<h3>책 장바구니 쿠키 구현</h3>
<form action="shoppingCart.jsp" method="post">
<table style="width:400px; border:1px solid gray;">
<tr><th>책제목</th><th>가격</th><th>장바구니 담기</th></tr>
<tr><td>서블릿</td><td>22000</td><td><input type="checkbox" name="book" value="서블릿"></td></tr>
<tr><td>자바</td><td>24000</td><td><input type="checkbox" name="book" value="자바"></td></tr>
<tr><td>파이썬</td><td>20000</td><td><input type="checkbox" name="book" value="파이썬"></td></tr>
<tr><td>머신러닝</td><td>28000</td><td><input type="checkbox" name="book" value="머신러닝"></td></tr>
<tr><td>영상처리</td><td>33000</td><td><input type="checkbox" name="book" value="영상처리"></td></tr>
<tr><td colspan="3"><input type="submit" value="장바구니 담기"></tr>
</table>
</form>
 <div style="width:400px; border:1px solid gray; text-align:center">
<h3>장바구니 목록</h3>
<%
	// 쿠키 정보 읽기
	Cookie[] cookies = request.getCookies();
	for (int i=0;i<cookies.length;i++){
		if(cookies[i].getName().contains("book")){
			out.print((i+1)+"."+cookies[i].getValue()+"<br>");
		}
	}
%>
</div>
</body>
</html>