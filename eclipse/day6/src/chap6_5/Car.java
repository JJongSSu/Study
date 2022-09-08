package chap6_5;

public class Car {
	//public static final String model;
	String model;
	private int gas;
	
	//setter Method
	void setGas(int gas) {	//gas 주입한 결과
		//gas를 문자열로 받을 때
		//String digit = gas.substring(0, gas.length());
		//int igas = Integer.parseInt(digit);		//Integer.parseInt(숫자문자열)
		if(gas>60) {
			System.out.println((gas-60)+"양 초과, 60L만 주입함.");
			gas = 60;
		}
		this.gas = gas;
	}
	//getter Method
	int getGas() {
		return gas;
	}
	
	boolean isLeftGas() {
		if(gas==0) {
			return false;
		}
		else {
			return true;
		}
		
//		boolean isLeft = true;
//		if(gas == 0) {
//			System.out.print("gas가 없습니다.\n");
//			isLeft = false;
//		}
//		else
//			System.out.print("gas가 있습니다.\n");
//		return isLeft;
	}
	
	void run() {
		while(isLeftGas()) {
			if(gas>0) {
				System.out.println("gas 잔량 : " + gas);
				gas -= 1;
			}
			else {
				System.out.println("멈춥니다. gas 잔량 : " + gas);
				break;
			}
		}
	}
	
}

