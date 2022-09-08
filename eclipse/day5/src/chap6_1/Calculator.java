package chap6_1;

public class Calculator {
	
	private int operand1;
	private int operand2;
	private String operator;
	
	//constructor(생성자) : 객체 초기화
	public Calculator() {
		this.operand1 = 10;
		this.operator = "+";
		this.operand2 = 20;
	}
	public Calculator(int o1, String op, int o2) {
		this.operand1 = o1;
		this.operator = op;
		this.operand2 = o2;
	}
	
	// custom method
	// int : 반환유형, 리턴 타입 -> 메소드 처리 후 반환하는 값의 유형 / return으로 값 반환
	public int calc() {
		int result = 0;  //지역변수 : 선언할 때 초기화 해줘야 함
		if(operator.equals("+"))
			result = operand1 + operand2;  //인스턴스 변수 : 객체가 있는동안 계속 유효한 변수
		else if(operator.equals("-"))
			result = operand1 - operand2;
		else if(operator.equals("*"))
			result = operand1 * operand2;
		else if(operator.equals("/"))
			result = operand1 / operand2;
		return result;
	}

}
