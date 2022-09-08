package chap8;

public interface Phone {
	// 인터페이스에 선언된 모든 필드는 정적 최종이다.(=상수 변수) 
	String PHONE_NUMBER = "010-1234-1234";	/* 맨앞에 public static final 생략되어 있음 */ 
	void call(String phoneNumber);	/* void 앞에 abstract 생략되어 있음 */ 
	void receive();

}
