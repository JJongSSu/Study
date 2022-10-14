<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
//https://nossodia.tistory.com/172(DBCP 이용한 코드 설명)
//https://blog.naver.com/blerang055/222405133166
	Connection conn; 
	//DB에 접근하게 해주는 객체
	
	PreparedStatement pstmt; 
	ResultSet rs; 
	//정보를 담을 객체
	try
	{
		String dbURL = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf-8"; 
		//localhost의 MySQL 3306포트 memberdb라는 DB 접속 경로를 dbURL에 저장.
		
		String dbID = "root";
		String dbPassword = "tbrs00002b";
		Class.forName("com.mysql.jdbc.Driver"); 
		 //MySQL에 접속할 수 있도록 매개체 역할을 해주는 하나의 라이브러리, JDBC 드라이버 로드
		
		conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		//DB 접속되면 conn 객체에 접속정보가 저장됨.
		if(conn!=null) System.out.print("커넥션 성공: ");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</body>
</html>