package chap6_5;

import java.lang.*;

public class NewNumber extends Number {
//abstract : 추상 클래스 -> 객체 생성 X, 추상 메소드를 모두 설정하지 않고 사용할 수 있음
	
	/*
	public short shortValue() {	//overriding
		return -1;
	}
	*/
	
	private int value;
	
	public NewNumber(int i) {
		value = i;
	}
	
	public byte byteValue() {	//재정의
		return (byte)(value*2);
	}
	
	/*
	public byte byteValue() {	//재정의
		System.out.println(super.byteValue());	//super 클래스에서 가져와서 재정의
		return -1;
	}
	*/
	
	public short shortValue() {	//overriding
		return (short)(value*2);
	}
	
	@Override
	public int intValue() {	//unimplemented 메소드 구현
//		Number num = new Number();	//추상 클래스는 객체 생성 불가
//		NewNumber newNum = new NewNumber();
		return 0;
	}

	@Override
	public long longValue() {
		
		return 0;
	}

	@Override
	public float floatValue() {

		return 0;
	}

	@Override
	public double doubleValue() {

		return 0;
	}	
	//추상클래스를 상속
	//추상 클래스 : 추상 메소드를 하나 이상 가지고 있는 클래스
	//추상 메소드 : abstract 예약어와 메소드 선언(사용법)만을 갖는 메소드
	//			상속 받은 클래스에서 구현해야 함을 명시하는 역할
	//클래스 : 모든 메소드가 구현된 상태

	

}
