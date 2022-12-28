<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Query animate() 함수</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('button').click(function(){
			$('div').animate({height:300},"slow");
			$('div').animate({width:300},"slow");
			$('div').animate({height:100},"slow");
			$('div').animate({width:100},"slow");
		})
	});
</script>
</head>
<body>
	<button>애니메이션 시작</button>
	<br><br>
	<div style="background:greenyellow; width:100px; height:100px; position:relative"></div>
</body>
</html>