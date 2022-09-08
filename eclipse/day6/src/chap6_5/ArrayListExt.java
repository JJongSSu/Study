package chap6_5;

//JCF : java collection framework
//상속, 인터페이스, 추상클래스, 제너릭(generics <>)
//같은 패키지에 존재하는 클래스나 java.lang 패키지에 포함된 클래스는 import 없이 사용 가능

import java.util.*;

public class ArrayListExt<T> extends ArrayList<T>{
	
	public void printHello() {	//추가
		System.out.println("클래스 어렵다");
	}
	
	public boolean add() {	//중첩(overloading) : 이름 같고, 매개변수 개수와 타입 다름(기존 메소드 사용 가능)
		super.add((T)"이종수");
		//System.out.println("자바프로그래밍");
		return true;
	}
	
	public int lastIndexOf(Object o) {	//재정의 : 이름, 매개변수 개수, 타입 같음(기존 메소드 사용 불가)
		return 100;
	}
}
