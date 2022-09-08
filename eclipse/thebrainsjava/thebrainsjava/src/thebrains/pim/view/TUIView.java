package thebrains.pim.view;

import thebrains.pim.model.Member;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TUIView {
	Member m = new Member();
	Scanner sc = new Scanner(System.in); // 키보드로부터 입력을 받음 단어 처리가 용이함

	public void showMenu(boolean isLogin, boolean isRoot) { // 메뉴 보기
		if(isLogin == false) { // 로그인 전 : 로그인 true
			System.out.print("0. 종료 ");
			System.out.print("1. 등록 ");
			System.out.print("2. 로그인 ");
			System.out.print("\n");
		}
		else {
			if(isRoot == false) { // 로그인 후 일반 사용자
				System.out.print("3. 조회 ");
				System.out.print("4. 수정 ");
				System.out.print("5. 탈퇴 ");
				System.out.print("6. 로그아웃 "); // isLogin값 false로 설정	
				System.out.print("\n");
			}
			else { // 관리자
				System.out.print("0. 종료 ");
				System.out.print("4. 수정 ");
				System.out.print("6. 로그아웃 ");
				System.out.print("7. 전체목록 "); 
				System.out.print("8. 전화번호 검색 "); // 지정한 조건으로 검색
				System.out.print("9. 이름 내림차순 정렬  "); // 지정한 조건으로 정렬
				System.out.print("10.범위 지정 page perCount");
				System.out.print("\n");
			}
		}		
	}

	public int inputMenu() { // 메뉴 입력
		int menu = 0 ;
		boolean flag = false;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if(menu < 0 || menu > 11 ) {
					System.out.println("해당 메뉴 번호를 입력하시오.");
				}
				else
					flag = true;
			} catch(InputMismatchException | NumberFormatException ime) {
				System.out.println("숫자 형식을 입력하시오.");
			}
		} while(!flag);
		return  menu;
	}

	public int inputMno() { // Mno
		System.out.println("멤버 번호 >>");
		int mno = Integer.parseInt(sc.nextLine());
		return mno;
	}
	public String inputEmail() {
		System.out.println("이메일을 입력하시오(id@thebrains.com) >>");
		String email = sc.nextLine();
		return email;
	}
	public String inputPw() {
		System.out.println("암호을 입력하시오 >>");
		String mpw = sc.nextLine();
		return mpw;
	}
	public String inputName() {
		System.out.println("이름을 입력하시오 >>");
		String mname = sc.nextLine();
		return mname;
	}
	public String inputPhone() {
		System.out.println("전화번호를 입력하시오(nnn-nnnn-nnnn) >>");
		String phone = sc.nextLine();
		return phone;
	}
	public String inputAddress() {
		System.out.println("주소를 입력하시오 >>");
		String address = sc.nextLine();
		return address;
	}
	public int showUpdateMenu() {
		System.out.println("수정 항목 번호를 입력하시오 >>");
		System.out.print("0. 수정 종료 ");
		System.out.print("1. 이름 ");
		System.out.print("2. 이메일 ");
		System.out.print("3. 연락처");
		System.out.print("4. 주소 "); 
		return Integer.parseInt(sc.nextLine());
	}
}

