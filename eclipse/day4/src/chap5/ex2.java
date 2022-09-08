package chap5;

public class ex2 {

	public static void main(String[] args) {
	
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			System.out.println(arr[i]);
		}
		arr[0] = 10;
		arr[1] = 10;
		arr[2] = 10;
		for(int i=0;i<3;i++) {
			System.out.println(arr[i]);
		}
		int num = arr.length;
		System.out.println(num);
		
	}
}
