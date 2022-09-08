package chap6_1;

public class CalculatorExam {

	public static void main(String[] args) {
		
		//기본 생성자(매개변수가 없는)를 호출하여 객체를 생성
		// calculator : 객체 참조 변수
		Calculator calculator = new Calculator();
					//참조변수		클래스의 생성자
		calculator = new Calculator(23,"*",40);
		System.out.println(calculator.calc());
		
		ModCalculator modCalculator = new ModCalculator();
		System.out.println(modCalculator.calc());
		

	}

}
