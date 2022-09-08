package chap7_1;

// 다각형의 넓이를 구하기 위한 클래스를 정의하고 객체생성, 활용
// 추상메소드를 가진 클래스(추상클래스)는 abstract 붙여줘야 됨
public abstract class Polygon {
	// 삼각형, 직사각형, 정사각형, 평행사변형, 사다리꼴
	private int height;
	private int width;
	private int area;
	private int depth;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 생성자를 만들어 초기화 시켜서 실행
	// 생성자가 없을 때 기본 생성자를 만들어주지만 생성자가 하나라도 있으면 기본생성자도 직접 만들어야 함
	public Polygon() {
		
	}
	
	public Polygon(int height) {
		this.height = height;
	}
	
	public Polygon(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	// 값을 변경할 수 있음
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public abstract int evaluate();	// 추상 메소드 : 상속받는 쪽에서 구현

}
