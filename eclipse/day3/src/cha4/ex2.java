package cha4;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		
		//char 타입 변수 이용해서 대소문자 관계없이 동일하게 처리
		
		Scanner scanner = new Scanner(System.in);
		
		String grade = scanner.nextLine();
		// int password = Integer.parseInt(scanner.nextLine());
		
		switch(grade) {
			case "A":
			case "a":
			case "에이":	
				System.out.println("우수 회원입니다.");
				break;
			case "B":
			case "b":
				System.out.println("일반 회원입니다");
				break;
			default:
				System.out.println("손님입니다");
		}
		
	}

}
