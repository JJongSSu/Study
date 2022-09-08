package chap8;

// 클래스 단일 상속 <sub class> extends <super class>
// 인터페이스 다중 상속 <sub인터페이스> extends <super인터페이스>, <super인터페이스>
// 인터페이스 다중 구현 지원 <class> implements <인터페이스>, <인터페이스>
// 다중구현
public class Smartphone implements Cameraphone, Messenger, Timer {
	
	@Override
	public String toString() {	// toString 재정의
		return Cameraphone.PHONE_NUMBER + "스마트폰 입니다";
	}
	
	@Override
	public void call(String phoneNumber) {
		System.out.println(phoneNumber + "에 전화를 겁니다.");
	}

	@Override
	public void receive() {
		System.out.println("전화를 받습니다.");
	}
	
	@Override
	public void sendMsg(String phoneNumber, String msg) {
		System.out.printf("[%s]로 %s메세지 전송\n",phoneNumber, msg);
	}

	@Override
	public void receiveMsg() {
		System.out.println("메세지가 도착했습니다.");
	}
	
	@Override
	public void playBeep() {
		System.out.println("알람 : 비프음 재생");
	}

	@Override
	public void playMusic(String title) {
		System.out.printf("알람 : %s 음악 재생\n", title);
	}
	
	public void takeaPicture() {
		System.out.println("사진 촬영");
	}


}
