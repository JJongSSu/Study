/**
 * ID 중복체크
 */
 
 function idCheck(id){
	if(id==""){
		alert("아이디를 입력하세요");
	}
	else{
		url="idCheck.jsp?mem_id="+id;	//get 방식
		window.open(url, "get", "width=350, height=150");
	}
}