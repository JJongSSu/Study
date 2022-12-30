package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBbean {
	//멤버변수(=property, 중간저장소)
	private String mem_id;
	private String mem_pwd;
	
	//오라클 DB에 관련된 객체 멤버변수 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//오라클 JDBC 연동을 위한 driver, url 설정
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//오라클 DB 연동 매소드
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "testdb", "testdb1234");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//오라클 DB 연동 종료(자원 해제) 메소드
	public void disconnect() {
		try {
			pstmt.close();
			conn.close();
			rs.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//ID 중복체크 메소드
	public int confirmId(String mem_id) {
		connect();
		int idDuplication = 0;
		try {
			String Confirm_SELECT = "select mem_id from member where mem_id=?";	//prepair statement 방식 : 보안에 좋음
			pstmt = conn.prepareStatement(Confirm_SELECT);
			pstmt.setString(1, Confirm_SELECT);
			rs = pstmt.executeQuery();	// SQL 문장 실행 후 결과값 저장
			
			if(rs.next()) {
				idDuplication = 1;	//ID 중복
			}
			else {
				idDuplication = -1;	//ID 중복 x(사용 가능)
			}
		}
		catch(Exception e) {
			System.out.println("confirmId(): " + e);
		}
		finally {
			disconnect();
		}
		return idDuplication;
	}

	
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getJdbc_driver() {
		return jdbc_driver;
	}

	public void setJdbc_driver(String jdbc_driver) {
		this.jdbc_driver = jdbc_driver;
	}

	public String getJdbc_url() {
		return jdbc_url;
	}

	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}
	
}
