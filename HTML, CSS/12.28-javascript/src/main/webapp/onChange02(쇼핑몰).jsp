<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 사이트에서 상품 구매시 색깔, 사이즈 선택</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jquery 문법 : $(선택자1, 선택자2).액션 -->
<script>
	function hideOption(){
		$('#select02, #select03').hide();
		itemChange();
		//jQuery('#select02, #select03').hide();
	}
	
	function itemChange(){
		$('select[name=option01]').change(function(){
			$('#select02').show();
		});
		
		$('select[name=option02]').change(function(){
			$('#select03').show();
		});
	}
</script>
</head>
<body onload="hideOption();">
	<form name="shoppingForm">
		<h1>현대 백화점</h1>
		<b>맨투맨 옵션 선택</b>
		<br><br>
		<select id="select01" name="option01">
			<option selected>상품명 선택</option>
			<option value="나이키 맨투맨">나이키 맨투맨</option>
			<option value="아디다스 맨투맨">아디다스 맨투맨</option>
			<option value="MLB 맨투맨">MLB 맨투맨</option>
			<option value="빈폴 맨투맨">빈폴 맨투맨</option>
			<option value="마리떼 맨투맨">마리떼 맨투맨</option>
		</select>
		<br><br>
		<select id="select02" name="option02">
			<option selected>색상 선택</option>
			<option value="black">black</option>
			<option value="white">white</option>
			<option value="gray">gray</option>
			<option value="kaki">kaki</option>
			<option value="navy">navy</option>
		</select>
		<br><br>
		<select id="select03" name="option03">
			<option selected>사이즈 선택</option>
			<option value="L">L | 50,000원 | 5개 남음</option>
			<option value="M">M | 50,000원 | 3개 남음</option>
			<option value="S">S | 50,000원 | 품절</option>
		</select>
	</form>
</body>
</html>