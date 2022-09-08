package chap6_5;

public class CarExample {
	public static void main(String[] args) {
//		String str = "현대자동차";
//		System.out.println(str.charAt(1));
//		int i = 66;
//		//Integer : int 기본형을 효과적으로 조작하기 위해 정의한 클래스
//		//Wrapper Class : 기본형을 효과적으로 조작하기 위해 정의한 클래스
//		System.out.println(Integer.toHexString(i));  //16진수로 변경
//		System.out.println(Integer.toBinaryString(i));  //2진수로 변경
		
		Car car = new Car();	//객체 생성
		car.model = "현대차";		//인스턴스 변수 값 입력(assignment)
		
		car.setGas(30);
		System.out.println(car.getGas());
		car.run();
	}

}
