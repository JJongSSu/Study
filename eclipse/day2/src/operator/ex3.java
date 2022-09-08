package operator;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String name = scanner.nextLine();

		System.out.println("비밀번호 : ");
		int password = Integer.parseInt(scanner.nextLine());
		
		if (name.equals("java") && password == 12345) {    		// System.out.println((name.equals("java") && password == 12345) ? true : false);
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
				
		/*
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String name = scanner.nextLine();

		System.out.println("비밀번호 : ");
		int password = Integer.parseInt(scanner.nextLine());
		
		if (name.equals("java")) {
			if(password  == 12345) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("비밀번호 잘못 입력");
			}
		}
		else {
			System.out.println("로그인 실패");
		}
		*/
	}

}
