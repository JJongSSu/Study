package chap7_1;

public class Triangle extends Polygon{
	// 생성자 : 객체 초기화
	// sub 클래스로부터 객체를 생성할 때 super 클래스의 객체(필드, 메소드)도 준비되어야 함
	public Triangle(int height, int width) {
		super(height,width);
		setName("Triangle");
	}

	@Override	// annotation : 컴파일러에게 정보제공
	public int evaluate() {	//재정의		// 메소드 선언부 : 사용법 또는 활용법
		int area = getHeight() * getWidth() / 2;
		return area;
	}

}
