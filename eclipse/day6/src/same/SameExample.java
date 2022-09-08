package same;

import other.Other;
import other.Protected;

public class SameExample extends Protected {

	public static void main(String[] args) {
		
		Same same = new Same();
		System.out.println(same.privateField);	//private는 같은 패키지에 있어도 사용 안됨
		System.out.println(same.defaultField);
		System.out.println(same.protectedField);
		System.out.println(same.publicField);
		
		SameExample sameExample = new SameExample();	//상속 받은 클래스에서 생성자 만들어야 됨
		System.out.println(sameExample.privateField);	//private는 같은 패키지에 있어도 사용 안됨
		System.out.println(sameExample.defaultField);	//다른패키지에 있으면 실행안됨
		System.out.println(sameExample.protectedField);	//상속되면 사용가능
		System.out.println(sameExample.publicField);
		
		Other other = new Other();
		System.out.println(same.privateField);	//private는 같은 패키지에 있어도 사용 안됨
		System.out.println(same.defaultField);	//다른패키지에 있으면 실행안됨
		System.out.println(same.protectedField);	//다른패키지에 있으면 실행안됨
		System.out.println(same.publicField);

	}

}
