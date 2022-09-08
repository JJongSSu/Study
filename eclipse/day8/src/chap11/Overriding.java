package chap11;

public class Overriding {
	public void testEquals(Object o1, Object o2) {
		if(o1 instanceof String && o2 instanceof String) {
			// Object들의 비교는 같은 객체냐?
			// if문에서 문장이 1개이면 {} 없어도 실행됨
			if(((String)o1).equals((String)o2)) {
				System.out.println("두 문자열의 값이 같다");
			}
			else {
				System.out.println("두 문자열의 값이 다르다");
			}
		}
		else {
			// Object들의 equals는 값이 아닌 같은 객체냐?
			if(o1.equals(o2)) {
				System.out.println("참조하는 객체가 같다");
			}
			else {
				System.out.println("참조하는 객체가 다르다");
			}
		}
	}

}
