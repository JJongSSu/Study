package cha4;

public class ex1 {

	public static void main(String[] args) {
		
		//시간표 작성
		int time = (int)(Math.random()*24)+1;
		
		System.out.println("현재 시각: "+time+"시");
		
		switch(time) {
		case 8:
			System.out.println("출근합니다");
		case 9:
			System.out.println("회의를 합니다");
		case 10:
			System.out.println("업무를 봅니다");
		case 11:
			System.out.println("외근을 나갑니다");
			break;
		}

	}

}
