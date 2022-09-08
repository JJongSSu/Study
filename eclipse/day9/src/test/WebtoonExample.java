package test;

import java.util.ArrayList;

public class WebtoonExample {
	public static ArrayList<Book> alBook = new ArrayList<Book>();
	
	public static void main(String[] args) {
		
		// 등록 -> Scanner 사용해서 입력한다음 add를 통해 등록 가능
		Book w1 = new Webtoon("i-1234","나혼자 레벨업", "판타지", "추공");
		Book w2 = new Webtoon("i-4567","미생2", "드라마", "윤태호");
		Book w3 = new Webtoon("i-1567","기생수", "스릴러", "몰라");
		
		alBook.add(w1);
		alBook.add(w2);
		alBook.add(w3);
		alBook.add(new Webtoon("i-8762","장풍전", "코믹", "신영우"));
		
		// 출력
		for(Book b : alBook) {	// Object : toString, equals, hashCode
			System.out.println(b.toString());	// Webtoon 클래스에 toString을 재정의했기 때문에 사용 가능
		}
		
	}
}
