package chap7_1;

public class 강제타입변환 {
	public static void main(String[] args) {
		String sRef = "Hello";
		Integer iRef = Integer.valueOf(100);	// Wrapper Class
		Integer iRef2 = 30;		// AutoBoxing
		// Integer iRef2 = (Integer) 30;
		
		Object o = (Object) iRef;
		sRef = (String) o;	// o는 실제로 Integer이기 때문에 문장은 맞지만 실행되지는 않음
		sRef.substring(3);
	}

}
