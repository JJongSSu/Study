package chap7_1;

public class Rectangle extends Polygon{
	public Rectangle(int height, int width) {
		// 컴파일러가 super 클래스의 해당 생성자를 호출
		super(height, width);
		setName("Rectangle");
	}

	@Override	// annotation : 컴파일러에게 정보제공
	public int evaluate() {	//재정의(overriding) : 매소드 이름, 매개변수 타입과 개수 모두 같음
		return (getWidth() * getHeight());
	}
	

}
