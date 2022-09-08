package chap6_2;

public class Gugudan {
	private int col = 9;
	private int row = 9;
	int dan;  //인스턴스 변수

	public void printOne(int dan) {	//dan : 지역변수
		for(int i=1;i<=col;i++) {
			System.out.println(dan+ "*" + i + "=" + (dan*i));
		}
	}
	public void printAll() {
		for(int dan=2;dan<=col;dan++) {
			printOne(dan);
		}
	}
	public void printFrom(int dan) {
		for(int i=dan;i<=col;i++) {
			printOne(i);
		}
	}

}
