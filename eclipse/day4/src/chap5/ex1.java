package chap5;

public class ex1 {

	public static void main(String[] args) {
		
		int[] scores;
		scores = new int[] {83,90,70};
		int sum = 0;
		for(int i=0;i<3;i++) {
			sum += scores[i];
		}
		System.out.println(sum);
		
		int sum1 = add(new int[] {83,90,70});  
		System.out.println(sum1);
		System.out.println();

	}
	
	//매소드를 만들어 이후에 add 계속 사용
	public static int add(int[] scores) {
		int sum2 = 0;
		for(int i=0;i<3;i++) {
			sum2 += scores[i];
		}
		return sum2;
	}

}