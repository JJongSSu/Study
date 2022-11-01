package test.buy;

/** <pre>
(우리집)
1) 꼬마야 왼손!(선언)
1-1. left
2) 왼손에 1000원 쥐어줌(대입)
2-1. left = 1000;
3) 아이스크림 사와라(명령, 입력값)
3-1. buyIcecream()
(거리)
4) CU 발견하고 찾아감
4-1. cu
(편의점)
5) cu점원에게 아이스크림"누가바" 주세요라고 요구(명령, 입력값)
5-1. cu.getIcecream()
6) 아이스크림"누가바" 꺼내 옴
6-1. "누가바"
7) 점원은 꼬마에게 "누가바"를 준다(입력받은 왼손 data에 대한 댓가로 주는 것)
7-1. return 6번
8. 꼬마는 점원이 준 아이스크림을 오른손에 받는다(왼손에 돈이 있기 때문)
8-1. right = 7번
(우리집)
9. 꼬마는 집에 와서 아이스크림을 나에게 준다(오른손에 있는 것 반환)
9-1. right
 **/
public class TestBuy {

	public static void main(String[] args) {
//		Object hi = "Hello";
//		System.out.println(hi);
		Object left;
		left = 1000;
		Object right = buyIcecream(left);
		System.out.println(right);
	}

	private static Object buyIcecream(Object left) {
		CU cu = new CU();
		String right = cu.getIcecream(left);
		return right;
	}

}
