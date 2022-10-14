<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- RequestDispatcher로 넘어오는 것은 ${param}으로 받아주고 request.setAttribute는 ${}으로 받아줌 -->
${param.num1 }+${param.num2 }=${requestScope.sum }
</body>
</html>