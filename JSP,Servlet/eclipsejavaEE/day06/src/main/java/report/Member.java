package report;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String grade;
	
	public Member() {
		// 기본 생성자
//		this.id = "smart";
//		this.pwd="1234";
//		this.name="홍길동";
	}

	public String getId() {
		return id;
	}

	// setter의 void는 출력값이 없음(return 값이 없음)
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String checkUser(String id, String pwd){
		//String name = null;
		if(id.equals(this.id) && pwd.equals(this.pwd)) {
			return this.grade;			
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
	
	public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
