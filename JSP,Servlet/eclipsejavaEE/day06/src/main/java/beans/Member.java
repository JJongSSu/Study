package beans;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String gender;
	
	public Member() {
		// 기본 생성자
		this.id = "smart";
		this.pw="1234";
		this.name="홍길동";
	}

	public String getId() {
		return id;
	}

	// setter의 void는 출력값이 없음(return 값이 없음)
	public void setId(String id) {
		this.id = id;
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
	
	public String checkUser(String id, String pw){
		//String name = null;
		if(id.equals(this.id) && pw.equals(this.pw)) {
			return this.name;			
		}
		else {
			//return name;
			return null;
		}
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
