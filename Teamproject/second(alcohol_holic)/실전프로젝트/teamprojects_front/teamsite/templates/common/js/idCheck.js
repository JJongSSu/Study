/**
 * id 중복 체크 메소드 구현
 */
 
 function idCheck(id) {
	if(id == ""){
		alert('아이디를 입력해 주세요!!');
	}else{
		url = "IdCheck.jsp?mem_id="+id;
		window.open(url, "get", "width=350, height=150");
	}
}