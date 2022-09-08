package chap4_1;

public class ex5 {

	public static void main(String[] args) {
		
		//4-3-2-1 순으로 *나열
		//n개 *부터 출력
//		for(int i=1;i<=4;i++) {
//			for(int j=4;j>=i;j--) {
//				System.out.print('*');
//				if(i==j) {
//					System.out.println();
		
		for(int i=1;i<5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print('*');
				if(j==i) {
					System.out.println();
				}
			}
		}

	}

}
