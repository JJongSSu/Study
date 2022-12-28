<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery의 slideToggle() 함수</title>
<style>
	div.panel, p.flip {
		width:560px;  margin:auto; padding:5px; background:yellow; border:solid 1px blue;
	}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(document).ready(/*콜백함수*/function(){
		$('.flip').click(function(){
			$('.panel').slideToggle("normal");	//slow, fast로 속도 조절 가능
		});
	});
</script>
</head>
<body>
	<div class="panel">
		<p>siledToggle() 함수를 사용하여</p>
		<p>선택한 엘리먼트 토글(slide-up & slide-down) 시키는 작업</p>
	</div>
	<p class="flip">여기를 클릭하세요</p>
</body>
</html>