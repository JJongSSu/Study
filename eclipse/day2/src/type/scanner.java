package type;

import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String inputData;
		
		while(true) {
			inputData = scanner.nextLine();
			System.out.println(inputData);
			if(inputData.equals("q")) {
				break;
			}
		}
		System.out.println("종료");
	}

}
