package test;

import java.util.Scanner;

public class q31 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String name, birthday_num, number;
		name = scanner.nextLine();
		birthday_num = scanner.nextLine();
		number = scanner.nextLine();
		
		String birthday_num_6 = birthday_num.substring(0,6);
		String number_6 = number.substring(0,11);
		
		System.out.println(name);
		System.out.printf("주민번호 앞 6자리 : %-6s\n", birthday_num_6);
		System.out.println(number_6);

	}

}
