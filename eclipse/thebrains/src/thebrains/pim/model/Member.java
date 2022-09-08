package thebrains.pim.model;

import java.util.Objects;

public class Member {	// 모델 객체에서 setter/getter 메소드를 가장 많이 사용

	private int mno;		// member number -> unique, primary
	private String email;	// 길이 20, 아이디로 사용 -> unique : 중복체크 해야됨. 기존에 있으면 새로 추가 x
	private String pw;		// 길이 15
	private String name;	// 길이 15
	private String phone;	// 길이 20
	private String address;	// 길이 50
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override	// 해쉬 알고리즘 : 많은 data들을 최소한의 정보를 이용하여 사용하기 위해 data들을 분류하는 알고리즘(필터링), 
				// 빅데이터를 저장할 공간을 모두 만드는 것이 아니라 처리속도를 높이기 위해 사용
	public int hashCode() {	// 제한된 정보로 식별자를 만들기 위해 사용하는 함수 
		return Objects.hash(email, mno, name);
	}
	
	@Override
	public boolean equals(Object obj) {	// 두 객체가 동일한 지에 대한 기준
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && mno == other.mno && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {	// 객체를 string화 하여 확인 용도로 사용
		return "Member [mno=" + mno + ", email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	
	
	
}
