package chap5_1;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.학생수, 2.점수입력, 3.점수리스트, 4.분석, 5.종료");
			System.out.println("------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo ==1) {
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			}
			else if(selectNo==2) {
				for(int i=0;i<studentNum;i++) {
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			}
			else if(selectNo==3) {
				for(int j=0;j<studentNum;j++) {
					System.out.println(scores[j]);
				}
			}
			else if(selectNo==4) {
				int sum = 0;
				int max = 0;
				double avg = 0.0;
				int count = 0;
				for(int k=0;k<studentNum;k++) {
					sum += scores[k];
					count++;
					if(max<scores[k]) {
						max = scores[k];
					}
				}
				avg = (double)sum/count;
				System.out.println(sum);
				System.out.println(avg);
				System.out.println(max);
			}
			else if(selectNo==5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		
	}

}
