package chap7_1;

public class Square extends Polygon{
	public Square(int length) {
		super(length, length);
		setName("Square");
	}

	@Override	// annotation : 컴파일러에게 정보제공
	public int evaluate() {	//재정의(overriding) : 매소드 이름, 매개변수 타입과 개수 모두 같음
		return (getWidth() * getHeight());
	}
	
}
