package iducs.java.pim.controller;

import iducs.java.pim.model.Member;
import iducs.java.pim.service.MemberService;
import iducs.java.pim.service.MemberServiceImpl;
import iducs.java.pim.view.MemberView;
import iducs.java.pim.view.TUIView;

import java.util.HashMap;
import java.util.Map;

public class MemberController {
    public static Map<String, Member> session = new HashMap<String, Member>(); // session 상태 map 객체로 처리
    public static TUIView tui = new TUIView(); // 메뉴, 입력을 위한 view - form
    MemberView memberView = null; // 결과 view

    final String MemberDB = "memberdb.txt"; // 파일 이름 지정
    MemberService<Member> memberService = null;
    public MemberController() {
        memberService = new MemberServiceImpl<Member>(MemberDB);
    }
    public void dispatch() {
        memberView = new MemberView();
        Member sessionMember = null; // session에 저장된 객체를 처리하는 데 사용
        Member member = null; // 임시적으로 사용할 목적

        boolean isLogin = false; // 로그인 여부
        boolean isRoot = false; // 관리자 여부

       // 파일로 부터 등록된 사용자 정보 읽기
        memberService.readFile();

        int menu = 0; // 0 입력 시 종료
        do {
            sessionMember = session.get("member"); // 로그인 성공 시 null이 아님
            if (sessionMember != null) {
                isLogin = true;
                if (sessionMember.getEmail().toString().equals("admin04@induk.ac.kr"))
                    isRoot = true;
            } else {
                isLogin = false;
                isRoot = false;
            }

            tui.showMenu(isLogin, isRoot); // 로그인 여부, 루트 여부에 따라 메뉴가 다름
            menu = tui.inputMenu();
            switch (menu) {
                case 0:// 종료 : 로그아웃, 파일로 저장
                    memberService.logout();
                    memberService.saveFile();
                    break;
                case 1:
                    member = new Member();
                    member.setId(MemberController.tui.inputId()); // 1001번 증가되지 않는 오류 해결
                    boolean isUnique; // 이메일 중복 확인
                    String email = MemberController.tui.inputEmail();
                    member.setEmail(email);
                    member.setPw(MemberController.tui.inputPw());
                    member.setName(MemberController.tui.inputName());
                    member.setPhone(MemberController.tui.inputPhone());
                    member.setAddress(MemberController.tui.inputAddress());
                    while (!isValid(member)) //유효성 확인
                        ;
                    if(memberService.postMember(member) > 0)
                        memberService.applyUpdate();
                    else
                        memberView.printFail("등록 ");
                    break;
                case 2:
                    member = memberService.login(MemberController.tui.inputEmail(), MemberController.tui.inputPw());
                    if(member != null) {
                        isLogin = true;// 성공
                        if(member.getEmail().contains("admin"))
                            isRoot = true;
                        session.put("member", member);
                    }
                    else
                        memberView.printFail("로그인 ");
                    break;
                case 7:
                    memberView.printList(memberService.getMemberList());
                    break;

            }
        }while(menu != 0);

        /**
         * 파일을 읽어서 회원 목록 객체를 생성
         * 메뉴를 출력(로그인 여부와 관리자 여부에 따라 다름)
         * 메뉴를 선택 -> 컨트롤러 객체가 요청을 받아
         * -> 서비스 객체의 해당 메소드가 호출 -> 리파지터리 객체의 해당 메소드 호출하여 데이터 처리
         * -> 반환된 결과를 서비스 객체의 메소드로 반환, 처리 -> 컨트롤러 객체에게 반환되면, 뷰에게 전달함
         * -> 뷰 객체가 처리된 결과를 출력(화면...)
          */
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
