package iducs.java.pim200412000.service;

import java.util.List;

public interface MemberService<T> {
    T login(String email, String pw);
    void logout();
    int postMember(T member); // create
    T getMember(T member); // read one
    List<T> getMemberList(); // read list
    int putMember(T member); // update
    int deleteMember(T member); // delete

    List<T> findMemberByPhone(T member); // 전화번호 뒷 4자로 검색, 여러개가 검색될 수 있음
    List<T> sortByName(String order); // order가 desc 면 내림차순, asc면 오름차순
    List<T> paginateByPerPage(int pageNo, int perPage);

    void readFile();
    void saveFile();
    void applyUpdate();
}
