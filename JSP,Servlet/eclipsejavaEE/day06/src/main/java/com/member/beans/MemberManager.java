package com.member.beans;

import java.util.ArrayList;

public class MemberManager {
	ArrayList<Member> ml = new ArrayList<>();
	
	public void add(Member member){
		ml.add(member);
	}
	
	public ArrayList<Member> getList(){
		return ml;
	}
	
}
