package thebrains.pim.controller;

import thebrains.pim.view.TUIView;

import java.util.HashMap;
import java.util.Map;

import thebrains.pim.model.Member;
import thebrains.pim.service.MemberService;
import thebrains.pim.service.MemberServiceImpl;

public class MemberController {	// 요청 제어하는 요소
	/*
	MVC(Model-View-Controller) : 모델 기반 개인정보관리시스템(PIM : personal information system) 개발
	MVCS(Model-View-Controller Service)
	CRUD(create read update delete) : 자료를 처리하는 기본 기능
	추가 기능 : 정렬, 검색, 페이지
	*/
	
	//MemberView memberView = null;
	MemberService<Member> memberService = null;
	public static TUIView tui = new TUIView();
	public static final String MEMBER_DB = "memberdb.txt";	//상수변수
	public static Map<String, Member> session = new HashMap<String, Member>();
	
	public MemberController() {
		memberService = new MemberServiceImpl<Member>();
	}
	public void dispatch() {	// dispatch : 시작의 의미, 명령을 가져옴
		Member sessionMember = null;
		memberService.readFile();
		boolean isLogin = true;
		boolean isRoot = true;
		int menu = 0;	// 0은 종료
		Member member = null;
		
		do {
			sessionMember = session.get("member");	// 로그인 했을 때 정보가 있으면 로그인
			if (sessionMember != null) {
				isLogin = true;
				if (sessionMember.getEmail().toString().equals("root@induk.ac.kr"))
					isRoot = true;
			} else {	//로그인 했을 때 비어있으면 로그인 x
				isLogin = false;
				isRoot = false;
			}
			// true, true : root 로그인 / true, false : 사용자 로그인 / false, false/true : 로그인전
			tui.showMenu(isLogin, isRoot);
			menu = tui.inputMenu();
			switch (menu) {
	            case 0:// 종료 : 로그아웃, 파일로 저장
	                //memberService.logout();
	                memberService.saveFile();
	                break;
	            case 1:
	                member = new Member();
	                member.setMno(MemberController.tui.inputMno()); // 1001번 증가되지 않는 오류 해결
	                boolean isUnique; // 이메일 중복 확인
	                String email = MemberController.tui.inputEmail();
	                member.setEmail(email);
	                member.setPw(MemberController.tui.inputPw());
	                member.setName(MemberController.tui.inputName());
	                member.setPhone(MemberController.tui.inputPhone());
	                member.setAddress(MemberController.tui.inputAddress());
	                //while (!isValid(member)) //유효성 확인
	                //    ;
	                if(memberService.postMember(member) > 0)
	                    memberService.applyUpdate();
	                else
	                    ;//memberView.printFail("등록 ");
	                break;
	            case 2: // 로그인
					sessionMember = memberService.login(tui.inputEmail(), tui.inputPw());
					break;

			}
			
		}
		while(menu != 0);
	}
}
