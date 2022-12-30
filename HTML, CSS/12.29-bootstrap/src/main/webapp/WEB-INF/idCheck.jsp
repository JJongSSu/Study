<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mem" scope="page" class="member.DBbean"/>

<%
	String mem_id = request.getParameter("mem_id");
	int idCheck = mem.confirmId(mem_id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck</title>
</head>
<body>
	<table border="0" align="center">
		<tr>
			<td align="center">
				<%
					if(idCheck==1){
				%><br>
				<%= mem_id %>는 이미 존재하는 id입니다.&nbsp;<br><br>
				<input type="button" value="닫기" onclick="javascript:self.close(); opener.document.memberForm.mem_id.focus();">
				<% }else{ %>
				<br>
				<%= mem_id %>는 사용 가능한 id입니다.&nbsp;<br><br>
				<input type="button" value="닫기" onclick="javascript:self.close(); opener.document.memberForm.mem_id.focus();">
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>