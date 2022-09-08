package test;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String lan;
		
		while(true) {
			lan = scanner.nextLine();
			System.out.println(lan);
			if(lan.length()>=13) {
				break;
			}
			
		}
		
		
	}

}
