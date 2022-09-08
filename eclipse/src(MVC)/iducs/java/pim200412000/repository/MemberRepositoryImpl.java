package iducs.java.pim200412000.repository;

import iducs.java.pim200412000.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl<T> implements MemberRepository<T> {
	public static long memberId = 1;
	public List<T> memberList = null;
	Member memberDTO = null;



	public MemberRepositoryImpl() {
		memberList = new ArrayList<T>();
	}

	@Override
	public int create(T member) {
		int ret = 0;
		try {
			memberList.add((T) member);
			ret = 1;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	@Override
	public T readById(T member) {
		T retMember = null;
		for (T m : memberList) {
			if(((Member) m).getId() == ((Member) member).getId()) {
				retMember = m;
				break;
			}
		}
		return retMember;
	}

	@Override
	public T readByEmail(T member) {
		T retMember = null;
		for (T m : memberList) {
			if(((Member) member).getEmail().equals(((Member) m).getEmail())) {
				retMember = m;
				break;
			}
		}
		return retMember;
	}

	@Override
	public List<T> readList() {
		return getMemberList();
	}

	@Override
	public int update(T member) {
		int ret = 0;
		for (T m : memberList) {
			if (((Member) m).getId() == ((Member) member).getId()) {
				memberList.set(ret, member);
			}
			ret++;
		}
		return ret;

	}

	@Override
	public int delete(T member) {
		int ret = 0;
		for (T m : memberList) {
			if (((Member) m).getId() == ((Member) member).getId()) {
				memberList.remove(m);
			}
			ret++;
		}
		return ret;
	}

	@Override
	public List<T> getMemberList() {
		return memberList;
	}
	@Override
	public void setMemberList(List<T> memberList) {
		this.memberList = memberList;
	}

	@Override
	public List<T> readListByPhone(T member) {
		return null;
	}

	@Override
	public List<T> readListByName(String order) {
		return null;
	}

	@Override
	public List<T> readListByPerPage(int page, int perPage) {
		return null;
	}

}
