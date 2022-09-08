package iducs.java.pim200412000.controller;

import iducs.java.pim200412000.model.Member;
import iducs.java.pim200412000.service.MemberService;
import iducs.java.pim200412000.service.MemberServiceImpl;
import iducs.java.pim200412000.view.MemberView;
import iducs.java.pim200412000.view.TUIView;

import java.util.HashMap;
import java.util.Map;

public class MemberController {
	public static Map<String, Member> session = new HashMap<String, Member>();
	public static TUIView tui = new TUIView();
	final String MemberDB = "memberdb.txt";

	MemberService<Member> memberService = null;
	MemberView memberView = null;

	public MemberController() {
		memberService = new MemberServiceImpl<Member>(MemberDB);
	}
	public void dispatch() {
		memberView = new MemberView();
		Member sessionMember = null;
		Member member = null;

		boolean isLogin = false;
		boolean isRoot = false;

		// 파일로 부터 등록된 사용자 정보 읽기
		memberService.readFile();

		int menu = 0;
		do {
			sessionMember = session.get("member");
			if (sessionMember != null) {
				isLogin = true;
				if (sessionMember.getEmail().toString().equals("root@induk.ac.kr"))
					isRoot = true;
			} else {
				isLogin = false;
				isRoot = false;
			}

			tui.showMenu(isLogin, isRoot); // 로그인 여부, 루트 여부에 따라 메뉴가 다름

			menu = tui.inputMenu();
			switch (menu) {
				case 0: // 종료 : 로그아웃, 파일로 저장
					memberService.logout();
					memberService.saveFile();
					break;
				case 1: // 등록
					member = new Member();
					member.setId(MemberController.tui.inputId());

					// email 중복 확인 필요
					member.setEmail(MemberController.tui.inputEmail());

					member.setPw(MemberController.tui.inputPw());
					member.setName(MemberController.tui.inputName());
					member.setPhone(MemberController.tui.inputPhone());
					member.setAddress(MemberController.tui.inputAddress());
					while (!isValid(member)) //유효성 확인 : @, -, null등
						;
					if(memberService.postMember(member) > 0)
						memberService.applyUpdate();
					else
						memberView.printFail("등록에 실패");
				break;
				case 2: // 로그인
					sessionMember = memberService.login(tui.inputEmail(), tui.inputPw());
					break;
				case 3: // 조회
					memberView.printOne((Member) memberService.getMember(sessionMember));
					break;
				case 4: // 수정
					member = new Member();
					member.setId(sessionMember.getId());
					member.setEmail(sessionMember.getEmail());
					member.setPw(MemberController.tui.inputPw());
					member.setName(MemberController.tui.inputName());
					member.setPhone(MemberController.tui.inputPhone());
					member.setAddress(MemberController.tui.inputAddress());
					while (!isValid(member))
					if(memberService.putMember(member) > 0)
						memberView.printOne(member);
					else
						memberView.printFail("업데이트 실패");
					break;
				case 5: // 탈퇴
					if (memberService.deleteMember(member) > 0) {
						memberService.logout();
						memberView.printSuccess("삭제 성공");
					}
					else
						memberView.printFail("삭제 실패");
					break;
				case 6: // 로그아웃
					memberService.logout();
					break;
				case 7: // 전체 목록
					memberView.printList(memberService.getMemberList());
					break;
/*
				case 8: // 전화번호 검색
					memberView.printList(memberService.findMemberByPhone());
					break;
				case 9: // 이름 정렬
					memberView.printList(memberService.sortByName("desc"));
					break;
				case 10: // 범위지정 회원목록
					memberView.printList(memberService.paginateByPerPage(2, 3));
					break;
					*/
			}
		} while (menu != 0);
	}
	private boolean isValid(Member member) {
		boolean isValid = true;
		if (member.getEmail().length() == 0 && !member.getEmail().contains(new StringBuffer("@"))) { // 이메일 패턴 확인
			isValid = false;
			member.setEmail(MemberController.tui.inputEmail());
		}
		if (member.getPw().length() == 0)
			member.setPw(MemberController.tui.inputPw());
		if (member.getName().length() == 0)
			member.setName(MemberController.tui.inputName());
		if (member.getPhone().length() == 0 && !member.getPhone().contains(new StringBuffer("-"))) { // 전화번호 패턴 확인
			isValid = false;
			member.setPhone(MemberController.tui.inputPhone());
		}
		return isValid;
	}
}
