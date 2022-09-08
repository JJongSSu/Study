package chap11;

public class API {
	public static void main(String[] args) {
		// Object의 equals는 참조하는 객체가 같은지 확인
		// String의 equals는 문자열의 값이 같은지 확인
		Overriding over = new Overriding();
		
		Integer i1 = Integer.valueOf(100);	// 객체로 만드는 이유 : 활용하기 위함
		Integer i2 = Integer.valueOf(100);	// int = 100으로 하면 wrapper 등 이용할 수 없음 
		if(i1 == i2) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		over.testEquals(i1,i2);
		
		String s1 = new String("비지니스 분석가");	// new String는 객체를 각각 1개씩 만듬
		String s2 = new String("비지니스 분석가");	// 문자열 "비지니스 분석가"만 입력하면 두개의 참조변수가 하나의 객체에 링크되는 방식으로 연결됨
		if(s1 == s2) {	// 두 참조변수가 참조하는 객체는 같은가?
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println(s1.hashCode());	// 해당 객체를 비트단위로 나타냄
		System.out.println(s2.hashCode());
		over.testEquals(s1,s2);
		
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.toString());	// toString : 해쉬코드의 16진수 값 반환(Object 클래스), String 클래스에서는 재정의해서 문자열 값을 반환
		System.out.println(o2.toString());
		if(o1 == o2) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		over.testEquals(o1,o2);
		
		// shift 연산 : 비트단위 연산
		// >> : 128을 비트패턴 1000 0000 오른쪽으로 세번 밀기
		//					0001 0000
		// 한번 오른쪽으로 밀때마다 2로 나누는 효과
		// << : 128을 비트패턴 1000 0000 왼쪽으로 세번 밀기
		//				100 0000 0000		
		// 한번 왼쪽으로 밀때마다 2를 곱해주는 효과
		System.out.println(128>>3);
		System.out.println(128<<3);
		System.out.println(Integer.toBinaryString(1024));
		
		Integer intRef = new Integer(100);
		// 예외처리문장 : 예외처리후 다음문장 실행
		try {	// 예외 발생 안할 경우 실행
			Integer intRef2 = Integer.valueOf("100L");
		}
		catch(NumberFormatException nfe) {	// 예외가 발생할 경우 실행
			System.out.println("예외발생 처리 : "+ nfe.getMessage());
		}
		finally {	// 무조건 실행
			System.out.println("예외 발생 여부와 상관없이 실행");
		}
		Integer intRef3 = 100; //autoboxing : 컴파일러가 알아서 (Integer)를 입력해줌
	}

}
