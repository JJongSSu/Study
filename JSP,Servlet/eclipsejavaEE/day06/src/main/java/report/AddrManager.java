package report;

import java.util.ArrayList;
import java.util.List;

public class AddrManager {
	// 주소록 목록을 관리하기 위한 ArrayList
	List<AddrBean> addrlist = new ArrayList<AddrBean>();
	
	public AddrManager() {
		addrlist = new ArrayList<AddrBean>();
		AddrBean admin = new AddrBean();
		admin.setid("admin");
		admin.setpwd("1234");
		admin.setUsername("이종수");
		admin.setGrade("1");
		admin.setGender("man");
		admin.setAddr("서울시");
		admin.setTel("01012345678");
		
		addrlist.add(admin);
	}
	
	// 주소록 추가 메서드
	public void add(AddrBean ab) {
		addrlist.add(ab);
	}
	
	// 주소록 목록 전달 메서드
	public List<AddrBean> getAddrList() {
		return addrlist;
	}
	
	// 특정 사용자를 주소록 목록에서 검색하는 메서드
	public AddrBean getAddr(String getid) {
		for(AddrBean ab : addrlist) {
			if(ab.getid().equals(getid))
				return ab;
		}
		return null;
	}
}
