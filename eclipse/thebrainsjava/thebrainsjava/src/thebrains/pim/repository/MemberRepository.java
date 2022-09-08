package thebrains.pim.repository;

import java.util.List;

public interface MemberRepository<T> { // DB와 연동
    // Generic을 사용함. T는 타입파라미터로 생성시 결정됨
    // MemberRepository 구현체 - MemberRepositoryImpl를 생성하기 위한 프로그래밍 요소
    int create(T member); // 생성, 등록
    T readById(T member); // mno 조회 단수
    T readByEmail(T member); // email 조회 단수
    List<T> readList(); // 조회 복수
    int update(T member); // 수정, 업데이트
    int delete(T member); // 삭제, 탈퇴

    // 메모리 처리, 파일 처리 or 데이터베이스 처리
    List<T> getMemberList(); // 멤버 목록 객체를 접근
    void setMemberList(List<T> memberList); // 멤버 목록 객체를 설정
}
