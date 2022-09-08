package chap11;

public class Car {
	private double speed = 20;
	public void speedUP() {
		speed = speed * (1 + Math.random());	//Math 클래스 : 수학관련
		System.out.println("속도증가" + speed);
	}

}
