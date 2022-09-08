package thebrains.pim.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import thebrains.pim.controller.MemberController;
import thebrains.pim.model.Member;
import thebrains.pim.repository.MemberRepository;
import thebrains.pim.repository.MemberRepositoryImpl;

public class MemberServiceImpl<T> implements MemberService<T>{	
	// Service : data를 DB에서 가져와서 가공하거나 결과를 DB에 저장 요청
	// implements와 getter/setter 겹치지 않게 해야 됨 -> 한 클래스에 같이 입력하면 안됨
	
	MemberRepository<T> memberRepository = null;	// DB, File 입출력을 담당
	private String memberdb = MemberController.MEMBER_DB;
	public MemberServiceImpl() {
		memberRepository = new MemberRepositoryImpl<T>();	//생성자 초기화
		// this.memberdb = memberDB;
	}
	
	@Override
	public T login(String email, String pw) {
		boolean isLogin = false;
		T member = (T) new Member();
        ((Member) member).setEmail(email);
        ((Member) member).setPw(pw);
        T retMember = memberRepository.readByEmail(member);
        if(retMember != null) {
        	System.out.println("로그인 성공");
        	MemberController.session.put("member", (Member) retMember);
        }
        else {
        	MemberController.session.put("member", (Member) retMember);
        	System.out.println("로그인 실패");
        }
		return null;
	}

	@Override
	public void logout() {
		
	}

	@Override
	public int postMember(T member) {
		if(memberRepository.create(member) > 0) {
			System.out.println("회원등록 성공");
			return 1;
		}
		else {
			System.out.println("회원등록 실패");
			return 0;
		}
	}

	@Override
	public T getMember(T member) {
		return null;
	}

	@Override
	public List<T> getMemberList() {
		//return memberRepository.getMemberList();
//        return memberRepository.readList();
		return null;
	}

	@Override
	public int putMember(T member) {
		return 0;
	}

	@Override
	public int deleteMember(T member) {
		return 0;
	}

	@Override
	public void readFile() {
		File file = new File(memberdb);	// 파일 객체를 생성 : 문자열 형태의 경로 정보
		if(file.canRead()) {	//존재하여서 읽을 수 있는 상태
			try {
				MemberFileReader<Member> mfr = new MemberFileReader<Member>(file);
				memberRepository.setMemberList((List<T>) mfr.readMember());
//				for(Member m : mfr.readMember()) {
//					System.out.println(m.getMno());
//					System.out.println(m.getEmail());
//					System.out.println(m.getName());
//				}
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
		else { // 읽을 수 없는 상태
			try {
				file.createNewFile();
			}
	        catch (IOException e) {
	        	e.printStackTrace();
	        }
		}
	}

	@Override
	public void saveFile() {
		// member list를 파일로 저장
        File file = new File(memberdb);
        try {
            MemberFileWriter<Member> mfw = new MemberFileWriter<Member>(file);
            mfw.saveMember((List<Member>) memberRepository.readList());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void applyUpdate() {// 등록 및 수정된 사항을 파일에 저장, 다시 맴버 목록 객체로 읽어옴
        saveFile();
        readFile();
	}
	
}
