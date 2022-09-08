package iducs.java.pim200412000.view;

import iducs.java.pim200412000.model.Member;

import java.util.List;

public class MemberView {
	public void printHeader() {
		System.out.printf("%-17s", "이메일" + "\t");
		//System.out.print("암호" + "\t");
		System.out.printf("%-5s", "이름" + "\t");
		System.out.printf("%-15s", "연락처" + "\t");
		System.out.print("주소" + "\n");
	}
	
	public void printList(List<Member> memberList) {
		printHeader();
		for(Member m : memberList) {
			printOne(m);	
		}
	}
	
	public void printOne(Member m) {
		System.out.print(m.getEmail() + "\t");
		//System.out.print(m.getMpw() + "\t");
		System.out.print(m.getName() + "\t");
		System.out.print(m.getPhone() + "\t");
		System.out.print(m.getAddress() + "\n");
	}
	
	public void printSuccess(String msg) {
		System.out.println(msg + "작업을 성공하였습니다.");
	}
	public void printSuccess(Member m, String msg) {
		printSuccess(msg);
		printOne(m);
	}
	public void printFail(String msg) {
		System.out.println(msg + "작업을 실패하였습니다.");
	}
}
