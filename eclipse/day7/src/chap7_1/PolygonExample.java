package chap7_1;

import java.util.ArrayList;

public class PolygonExample {
	
	// 매개변수에 배열을 사용하면 매개변수 개수를 가변적으로 사용 가능
	public static void main(String[] args) {
		Triangle triangle = new Triangle(60,80);
		System.out.println(triangle.evaluate());
		
		Rectangle rectangle = new Rectangle(20,40);
		System.out.println(rectangle.evaluate());
		
		Square square = new Square(40);
		System.out.println(square.evaluate());
		
		Trapezoid trapezoid = new Trapezoid(20,40,10);
		System.out.println(trapezoid.evaluate());
		
		// Polygon 형의 poly라는 참조변수 사용
		// 부모클래스의 참조변수는 자식클래스의 객체를 사용할 수 있다
		// Triangle, Rectangle, Square, Trapezoid 모두 Polygon 상속받음. 공통적인 특징을 가짐
		ArrayList<Polygon> arrPoly = new ArrayList<>();
		
		// 문법적으로 Polygon 시점에서 Triangle을 보기 때문에 Polygon 관점으로 접근
		// Polygon에 있는 메소드를 사용
		// Polygon을 Object로 형변환 했을 때 Object에는 추상메소드 evaluate()가 없기 때문에 인식하지 못하고 에러남
		// poly.evaluate()를 형변환 해줘야 함 -> ((Polygon)poly).evaluate()
		Polygon poly = /*(Polygon)*/ new Triangle(60,80);	// upper casting : 상속받은 쪽에서 상속해준 쪽으로 형변환 할 때 (Polygon) 생략 가능
		System.out.println(poly.evaluate());
		arrPoly.add(poly);
		
		poly = new Rectangle(20,40);
		System.out.println(poly.evaluate());
		arrPoly.add(poly);
		
		poly = new Square(40);
		System.out.println(poly.evaluate());
		arrPoly.add(poly);
		
		poly = new Trapezoid(20,40,10);
		System.out.println(poly.evaluate());
		arrPoly.add(poly);
		
		for(Polygon p : arrPoly) {
			whoIs(p);	// 다형성 사용
		}
	}
	// Polygon p에 맞게 선택해서 결과 출력
	// instanceof : 객체가 어떤 클래스의 인스턴스인지 확인
	public static void whoIs(Polygon p) {
	if(p instanceof Triangle)
		System.out.println("삼각형의 넓이는 : " + p.evaluate());
	else if(p instanceof Square)
		System.out.println("정사각형의 넓이는 : " + p.evaluate());
	else if(p instanceof Rectangle)
		System.out.println("사각형의 넓이는 : " + p.evaluate());
	else if(p instanceof Trapezoid)
		System.out.println("사다리꼴의 넓이는 : " + p.evaluate());
	else
		;
		
//		for(Polygon p : arrPoly) {
//			System.out.println(p.getName() + "넓이는 : " + p.evaluate());
//		}
	
	}
}
