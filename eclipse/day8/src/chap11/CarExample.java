package chap11;

public class CarExample {
	// throw : Exception 유형의 예외가 발생하면 호출한 메소드로 전달
	public static void main(String[] args) throws Exception {
		Class clazz  = Car.class;
		System.out.println(clazz.getPackageName()+"."+clazz.getSimpleName());
		Class clazz1 = Class.forName("chap11.Car");
		System.out.println(clazz1.getPackageName());
		
		// throws Exception 사용 안할 때
		try {
			clazz1 = Class.forName("chap11.Car");	//forName은 형을 확인하는 것이기 때문에 내용은 관계없이 문자열이면 컴파일에는 문제가 없다
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println(clazz1.getPackageName());
	}

}
