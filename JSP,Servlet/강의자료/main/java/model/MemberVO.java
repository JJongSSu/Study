package model;

//회원정보 정의하는 클래스
public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
	
	//모든 필드값을 받아서 초기화하는 생성자 정의
	public MemberVO(String name, String userid, String pwd, String email, String phone, int admin) {
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.admin = admin;
	}

	//로그인의 정보받아서 값 초기화 하는 생성자 정의
	public MemberVO(String userid, String pwd) {
		this.userid = userid;
		this.pwd = pwd;
	}

	//getter/setter 만들기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUesrid() {
		return userid;
	}

	public void setUesrid(String uesrid) {
		this.userid = uesrid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", uesrid=" + userid + ", pwd=" + pwd + ", email=" + email + ", phone="
				+ phone + ", admin=" + admin + "]";
	}

}
