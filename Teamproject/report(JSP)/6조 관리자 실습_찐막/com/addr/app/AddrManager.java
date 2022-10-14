package com.addr.app;

import java.util.ArrayList;
import java.util.List;

public class AddrManager {
	// 주소록 목록을 관리하기 위한 ArrayList
	List<AddrBean> addrlist;
	
	public AddrManager() {
		addrlist = new ArrayList<AddrBean>();
		AddrBean admin = new AddrBean();
		admin.setUserid("admin");
		admin.setUserpwd("1q2w3e4r");
		admin.setUsername("관리자");
		admin.setTel("1111");
		admin.setEmail("admin@admin.com");
		admin.setGender("불명");
		admin.setGrade(true);
		
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
	public AddrBean getAddr(String userid) {
		for(AddrBean ab : addrlist) {
			if(ab.getUserid().equals(userid))
				return ab;
		}
		return null;
	}
}
