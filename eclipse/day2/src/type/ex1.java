package type;

import java.io.IOException;

public class ex1 {

	public static void main(String[] args) throws IOException {
		
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println(keyCode);
			if(keyCode==113) {
				break;
			}
		}
		
		System.out.println("종료");
	}

}
