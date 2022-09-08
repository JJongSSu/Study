package thebrains.pim.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import thebrains.pim.model.Member;

public class MemberFileReader<T> {
	Scanner sc = null;
	public MemberFileReader(File f) throws FileNotFoundException {
		sc = new Scanner(f); // 파일로부터 입력 
		// new Scanner(System.in) : 키보드로부터 입력
	}
	public List<T> readMember() {
		List<T> memberList = new ArrayList<T>();
		while(sc.hasNext()) { // 스캐너로 읽을 것이 남아있는가?
			Member m = new Member();
			String strArr[] = sc.nextLine().split("\t"); // 한 라인씩 읽어서 탭기호로 구분
			// 각 라인을 tab 기호를 구분자로 사용하여 6개의 요소로 구분			
			m.setMno(Integer.parseInt(strArr[0]));// mno 는 int형 : -20억에서 +20억까지
			m.setEmail(strArr[1]);
			m.setPw(strArr[2]);
			m.setName(strArr[3]);
			m.setPhone(strArr[4]);
			m.setAddress(strArr[5]);
			memberList.add((T) m);
		}
		return memberList;
	}
}
