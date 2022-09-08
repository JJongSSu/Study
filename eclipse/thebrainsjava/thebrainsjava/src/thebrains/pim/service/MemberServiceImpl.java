package thebrains.pim.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import thebrains.pim.controller.MemberController;
import thebrains.pim.model.Member;
import thebrains.pim.repository.MemberRepository;
import thebrains.pim.repository.MemberRepositoryImpl;

public class MemberServiceImpl<T> implements MemberService<T> {
	// 데이터를 DB가져와서 가공하거나, 가공한 결과를 DB에 저장을 요청 
	MemberRepository<T> memberRepository = null; // DB 또는 File 입출력을 담당
	private String memberdb = MemberController.MEMBER_DB;
	
	public MemberServiceImpl() { // 실체를 생성
		memberRepository = new MemberRepositoryImpl<T>();
		// memberdb = memberDB; 
	}
	@Override
	public T login(String email, String pw) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}
	@Override
	public int postMember(T member) {
		if(memberRepository.create(member) > 0) {
			System.out.println("회원등록 성공");
			return 1;
		} else {
			System.out.println("회원등록 실패");
			return 0;
		}
		
	}
	@Override
	public T getMember(T member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int putMember(T member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteMember(T member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void readFile() {
	    File file = new File(memberdb); // 파일 객체를 생성 : 문자열 형태의 경로 정보
        if (file.canRead()) { // 존재하여서 읽을 수 있는 상태
            try {
                MemberFileReader<Member> mfr = new MemberFileReader<Member>(file);
                memberRepository.setMemberList((List<T>) mfr.readMember());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else { // 읽을 수 없는 상태
            try {
                file.createNewFile();
            } catch (IOException e) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public void applyUpdate() {
		saveFile();
		readFile();
	} 
}
