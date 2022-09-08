package chap4_1;

import java.util.Scanner;

public class ex7 {

	public static void main(String[] args) {
		
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");
			int a = Integer.parseInt(scanner.nextLine());
			if(a==1) {
				System.out.println("예금액:");
				balance += Integer.parseInt(scanner.nextLine());
				System.out.printf("예금액> %d\n", balance);
				continue;
			}
			else if(a==2) {
				System.out.println("출금액:");
				balance -= Integer.parseInt(scanner.nextLine());
				System.out.printf("출금액> %d\n",balance);
				continue;
			}
			else if(a==3) {
				System.out.printf("잔고> %d\n", balance);
			}
			else {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
