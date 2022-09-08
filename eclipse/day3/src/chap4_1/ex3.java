package chap4_1;

public class ex3 {

	public static void main(String[] args) {
		
		while(true) {
			int a = (int)(Math.random()*6)+1;
			int b = (int)(Math.random()*6)+1;	
			
			if((a+b)==5) {
				System.out.printf("(%d,%d)",a,b);
				break;
			}
			else{
				System.out.printf("(%d,%d)",a,b);	
				continue;
			}
		}

	}

}
