/**
 * 주민번호 체크 함수 구현
 */
 
 function juminCheck(jumin1,jumin2){
	var juminNum = jumin1 + jumin2;
	
	var sum=0;
	var temp=0;
	var result=0;
	var weight= new Array(2,3,4,5,6,7,8,9,2,3,4,5);
	
	for(i=0;i<12;i++){
		sum = sum + (juminNum.chatAt(i)) * weight[i];
	}
	temp = 11 - (sum%11);
	result = temp%10;
	if(result != juminNum.charAt(12)){
		alert("입력받은 주민번호는 틀린 주민번호입니다. 다시 확인해주세요");
		document.juminForm.jumin_num1.focus();
	}
	else{
		alert("정상 주민번호입니다.")
	}

}