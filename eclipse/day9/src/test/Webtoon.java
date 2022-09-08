package test;

import java.time.LocalDateTime;
import java.util.Objects;

// 웹툰 등록, 조회
// 웹툰은 Book 종류이다.
// 웹툰의 주요 속성은?	제목, 장르, 저자, 판매량, 요일
public class Webtoon implements Book {
	
	private String isbn;	// 유일한 식별자
	private String title;
	private String genre;
	private String author;
	private LocalDateTime date;	// 등록일자
	private int count;
	
	public Webtoon() {};
	public Webtoon(String isbn, String title, String genre, String author) {
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.date = LocalDateTime.now();
	}

	// 구현하는 인터페이스에 대해서 getter/setter 만들어줘야 함
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// 기본형 : package명.클래스명@16진수해쉬코드
		return "Webtoon [title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(author, genre, title, date);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)	// 참조하는 객체가 같으면 true
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Webtoon other = (Webtoon) obj;
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre)	// data 값이 같다면 true
				&& Objects.equals(title, other.title);
	}
	
	
	
}
