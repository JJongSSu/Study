package operator;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫 번째 수 : ");
		double a = Double.parseDouble(scanner.next());
		System.out.println("두 번째 수 : ");
		double b = Double.parseDouble(scanner.next());
		if ((b==0)||(b==0.0)) {
			System.out.println("무한대");
		}
		else {
			System.out.println(a/b);
		}
		
		
		
		
	}

}
