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

	int[] scorelist = new int[4];
	String name = request.getParameter("name");
	scorelist[0] = Integer.parseInt(request.getParameter("java"));
	scorelist[1] = Integer.parseInt(request.getParameter("web"));
	scorelist[2] = Integer.parseInt(request.getParameter("IoT"));
	scorelist[3] = Integer.parseInt(request.getParameter("android"));

	double avg = average(scorelist);
	
	String grade = "";
	if(95<=avg && avg<=100){
		grade = "A+";
	}
	else if(90<=avg && avg<=94){
		grade = "A";
	}
	else if(85<=avg && avg<=89){
		grade = "B+";
	}
	else if(80<=avg && avg<=84){
		grade = "B";
	}
	else{
		grade = "F";
	}
%>
<%!
	double average(int[] score){
		double avg = 0;
		for(int i=0; i<score.length; i++){
			avg += score[i];
		}
		avg = avg/score.length;
		return avg;
	}
%>
<!-- data 출력 -->
<div style="width:700px; border:solid 1px gray; text-align:center">
<h3>학점확인 프로그램</h3>
<table align="center">
<tr>
<td align="left">이름</td><td><%=name %></td>
</tr>
<tr>
<td align="left">java 점수</td><td><%=scorelist[0] %></td>
</tr>
<tr>
<td align="left">web 점수</td><td><%=scorelist[1] %></td>
</tr>
<tr>
<td align="left">IoT 점수</td><td><%=scorelist[2] %></td>
</tr>
<tr>
<td align="left">android 점수</td><td><%=scorelist[3] %></td>
</tr>
<tr>
<td align="left">평균</td><td><%=avg %></td>
</tr>
<tr>
<td align="left">학점</td><td><%=grade %></td>
</tr>
</table>
</div>
</body>
</html>