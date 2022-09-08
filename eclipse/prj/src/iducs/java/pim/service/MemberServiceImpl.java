package iducs.java.pim.service;

import iducs.java.pim.model.Member;
import iducs.java.pim.repository.MemberRepository;
import iducs.java.pim.repository.MemberRepositoryImpl;
import iducs.java.pim.view.MemberView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MemberServiceImpl<T> implements MemberService<T> {

    MemberView memberView = new MemberView();

    MemberRepository<T> memberRepository = null;
    private String memberdb = null;

    public MemberServiceImpl(String memberDB) {
        memberRepository = new MemberRepositoryImpl<T>();
        this.memberdb = memberDB;
    }

    @Override
    public T login(String email, String pw) {
        T member = (T) new Member();
        ((Member) member).setEmail(email);
        ((Member) member).setPw(pw);
        T retMember = memberRepository.readByEmail(member);
        if(retMember != null)
            return retMember;
        else
            return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public int postMember(T member) {
        int ret = 0;
        if(memberRepository.create(member) > 0)
            ret = 1;
        return ret;
    }

    @Override
    public T getMember(T member) {
        return null;
    }

    @Override
    public List<T> getMemberList() {
        //return memberRepository.getMemberList();
        return memberRepository.readList();
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

    @Override
    public void readFile() {
        File file = new File(memberdb); // 파일 객체를 생성
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
    public void applyUpdate() { // 등록 및 수정된 사항을 파일에 저장, 다시 맴버 목록 객체로 읽어옴
        saveFile();
        readFile();
    }
}
