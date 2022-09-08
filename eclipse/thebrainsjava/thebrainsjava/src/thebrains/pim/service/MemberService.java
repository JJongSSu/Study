package thebrains.pim.service;

import java.util.List; // ArrayList의 상위 클래스

public interface MemberService<T> { // MemberService에 대한 활용법 구현 요청(제한)
    T login(String email, String pw); // 로그인 처리
    void logout(); // 로그아웃 처리
    
    // HTTP(HyperText Transfer Protocol) method : post, get, put, delete .. patch, head, 
    int postMember(T member); // 회원 등록, http에서 post 메소드로 처리 -> repository create
    T getMember(T member); // 회원 정보 조회, get 메소드로 처리 ->  repository read one
    List<T> getMemberList(); // 회원 목록 조회, get 메소드로 처리 -> repository read list
    int putMember(T member); // 회원 정보 수정, put 메소드로 처리 -> repository update
    int deleteMember(T member); // 회원 탈퇴(삭제), delete 메소드로 처리 -> repository delete
    
    void readFile(); // 파일로 부터 읽어서 멤버 목록 객체 생성
    void saveFile(); // 멤버 목록 객체를 파일에 저장
    void applyUpdate(); // saveFile() -> readFile() 순으로 호출하여 처리함. 등록, 수정 시 발생
}
