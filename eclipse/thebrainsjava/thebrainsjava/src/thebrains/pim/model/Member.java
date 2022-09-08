package thebrains.pim.model;

import java.util.Objects;

public class Member { // Model 객체에서 Setter/Getter 메소드가 가장 많이 사용
	private int mno; 		// member number - unique, primary
	private String email; 	// email을 아이디로 사용, 길이 20 - unique
	private String pw; 		// 길이 15
	private String name; 	//길이 15
	private String phone; 	// 길이 20
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
	@Override
	public String toString() { // 객체를 String화 하여 확인 용도로 사용
		return "Member [mno=" + mno + ", email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	@Override
	public int hashCode() { // 해시함수 : 제한된 정보로 식별자를 만드는 사용하는 함수
		return Objects.hash(email, mno, name);
	}
	@Override
	public boolean equals(Object obj) { // 두 객체가 동일한 지에 대한 기준 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && mno == other.mno && Objects.equals(name, other.name);
	}	
}
