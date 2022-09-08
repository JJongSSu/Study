package iducs.java.pim200412000.repository;

import java.util.List;

public interface MemberRepository<T> {
    int create(T member);
    T readById(T member);
    T readByEmail(T member);
    List<T> readList();
    int update(T member);
    int delete(T member);

    List<T> readListByPhone(T member);
    List<T> readListByName(String order);
    List<T> readListByPerPage(int page, int perPage);

    List<T> getMemberList();
    void setMemberList(List<T> memberList);
}
