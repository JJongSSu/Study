package cha4;

import java.util.Scanner;

public class switch문 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String position = scanner.next();
		
		switch(position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");
	
			
		}

	}

}
