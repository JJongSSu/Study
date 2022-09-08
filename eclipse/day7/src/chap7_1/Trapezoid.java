package chap7_1;

public class Trapezoid extends Polygon{
	private int top;
	private int bottom;
	
	public Trapezoid(int top, int bottom, int height) {
		super(height);
		this.top = top;
		this.bottom = bottom;
		setName("Trapezoid");
	}
	public int getTop() {
		return top;
	}
	public int getBottom() {
		return bottom;
	}
	
	public int evaluate() {	//재정의(overriding) : 매소드 이름, 매개변수 타입과 개수 모두 같음
		return ((top+bottom)*getHeight())/2;
	}

}
