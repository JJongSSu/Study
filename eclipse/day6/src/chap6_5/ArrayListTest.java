package chap6_5;

public class ArrayListTest {

	public static void main(String[] args) {
		//implicit type conversion(묵시적 형변환) : 오토박싱	(<-> 언박싱)
		Integer m = (Integer) 100;	//Integer와 int는 다른 타입의 변수
		System.out.println(Integer.toBinaryString(m));	//이진수
		//제너럴 안에 있는 타입만 작성가능
		ArrayListExt<String> ale = new ArrayListExt<String>();
		ale.add("고객");
		ale.add("경험");
		ale.add("데이터를");
		ale.add("활용한");
		ale.add("과정");
		ale.printHello();	//추가
		ale.add();	//add(T) add() 중첩(overloading)
		System.out.println(ale.lastIndexOf("경험"));		//재정의, lastIndexOf : 마지막 인덱스의 단어 찾아줌
		
		//for문으로 순차 접근 가능
		for(int i=0;i < ale.size();i++) {
			System.out.print(ale.get(i)+" ");
		}
		
		//foreach statement : collection 객체의 순차 접근
		for(String a : ale)	
			System.out.print(a+" ");
		
	}

}
