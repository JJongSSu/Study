package chap8;

public class SmartphoneExample {
	// 인터페이스들을 정의하고 다중구현(multiple implementation)을 통해 클래스를 정의
	// 정의한 클래스로부터 객체를 생성하고 생성된 객체와 상호작용을 통해 문제를 해결
	// java는 다중 상속은 지원하지 않음 -> extends 뒤에 하나만 작성 가능
	// 인터페이스는 다중 구현이 가능 -> implements 뒤에 여러개 작성 가능
	public static void main(String[] args) {
		Smartphone sp = new Smartphone();
		//sp.call("010-1234-5678");
		sp.call(Phone.PHONE_NUMBER);	// 정적변수 : 변경할 수 없음
		sp.playMusic("포켓몬송");
		sp.sendMsg(Phone.PHONE_NUMBER, "피곤해!");
		
		Timer t = sp;	// sp가 참조하는 객체를 Timer 인터페이스를 구현한 구현체, Smartphone -> Timer : up-casting, 자동으로 됨
		((Smartphone) t).call(Smartphone.PHONE_NUMBER);	// Smartphone 클래스로 형변환, Smartphone과 상속관계이기 때문에 사용 가능
														// Timer -> Smartphone : down-casting, 우리가 지정해줘야 함
	}

}
