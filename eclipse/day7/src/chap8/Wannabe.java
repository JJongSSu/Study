package chap8;

public class Wannabe {	// 캡슐화(encapsulation) : 클래스로 필드, 메소드 구성 
						// 자료 추상화(data abstraction) : 자료를 처리하기 위한 최소한의 정보만을 사용할 수 있도록 함
						// 정보은닉(information hiding) : 필요한 정보만 접근하게 함, private 사용
	
	// 자료구조(Data structure) : 재료
	private String title;
	private String content;
	private String writer;
	private String regDate;
	
	// 자료구조를 활용하는 메소드 : 가공, 연산
	// 메소드 선언부분만 노출, 블록부분은 노출 안됨
	public void printAllFields() {
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(regDate);
	}
}
