package iducs.java.pim200412000.service;

import iducs.java.pim200412000.controller.MemberController;
import iducs.java.pim200412000.model.Member;
import iducs.java.pim200412000.repository.*; // intellij 에서 import 문제가 발생하여 *로 처리함
import iducs.java.pim200412000.view.MemberView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MemberServiceImpl<T> implements MemberService<T> {

	MemberView memberView = new MemberView();
	MemberRepository<T> memberRepository = null;
	private String memberdb = null;
	Object temporary = null;

	public MemberServiceImpl(String memberdb) {
		memberRepository = new MemberRepositoryImpl<T>();
		this.memberdb = memberdb;
	}

	@Override
	public T login(String email, String pw) {
		boolean isLogin = false;

		T member = (T) new Member();
		((Member) member).setEmail(email);
		((Member) member).setPw(pw);
		T retMember = (T) memberRepository.readByEmail(member);
		if (retMember != null) {
			memberView.printSuccess("로그인 성공");
			MemberController.session.put("member", (Member) retMember);
		} else {
			MemberController.session.put("member", (Member) retMember);
			memberView.printFail("로그인 실패");
		}
		return null;
	}

	@Override
	public void logout() {
		T member = (T) MemberController.session.get("member");
		if(member != null) {
			System.out.println(((Member) member).getEmail() + "님이 로그아웃 하셨습니다.");
			MemberController.session.remove("member"); // session invalidate
		}
	}

	@Override
	public int postMember(T member) {
		if (memberRepository.create(member) > 0) {
			memberView.printSuccess("회원 등록 ");
			return 1;
		} else {
			memberView.printFail("회원 등록 ");
			return 0;
		}
	}

	@Override
	public T getMember(T member) {
		// readById()는 T 유형의 객체를 매개변수로
		return memberRepository.readById(member);
	}

	@Override
	public List<T> getMemberList() {
		return memberRepository.readList();
	}

	@Override
	public int putMember(T member) {
		return memberRepository.update(member);
	}

	@Override
	public int deleteMember(T member) {
		return memberRepository.delete(member);
	}

	@Override
	public List<T> findMemberByPhone(T member) {
		return null;
	}

	@Override
	public List<T> sortByName(String order) {
		return null;
	}

	@Override
	public List<T> paginateByPerPage(int pageNo, int perPage) {
		return null;
	}

	public void readFile() { // 파일을 읽어서 member list 생성
		File file = new File(memberdb);
		if (file.canRead()) {
			try {
				MemberFileReader<Member> mfr = new MemberFileReader<Member>(file);
				memberRepository.setMemberList((List<T>) mfr.readMember());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveFile() { // member list를 파일로 저장
		File file = new File(memberdb);
		try {
			MemberFileWriter<Member> mfw = new MemberFileWriter<Member>(file);
			mfw.saveMember((List<Member>) memberRepository.readList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void applyUpdate() {
		saveFile();
		readFile();
	}
}
