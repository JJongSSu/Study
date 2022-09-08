package chap6_2;

//Gugudan 클래스가 import 되었거나 같은 패키지에 있는 경우 -> 상속 가능
public class SubGugudan extends Gugudan {
	
		//this(매개변수목록) : 현재 클래스의 생성자를 호출
		//super(매개변수목록) : 부모클래스의 생성자를 호출
	
	//direction : up(dan부터 시작), down(2단부터 dan까지)
	//overloading(중첩) -> 매소드 이름 같고, 매개변수 타입, 개수가 다름 / 매개변수 개수에 따라 다르게 설정할 수 있음 
	//overriding(재정의) -> 매소드 이름, 매개변수 타입과 개수 모두 같음
	//매소드 중첩
	public void printFrom(int dan, String direction) {
		
	}

}
