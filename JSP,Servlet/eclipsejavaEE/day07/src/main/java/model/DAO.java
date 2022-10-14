package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	// JDBC를 위한 자료형 선언
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	// 커넥션 메소드 정의
	public String getConnection(){
		String message = "fail";
		try {
			String url = "jdbc:mysql://localhost:3306/webdb?"
				      +"useUnicode=true&characterEncoding=utf-8";
			String uid = "root";
			String pass = "tbrs00002b";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, pass);
			message = "success";
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		return message; // 반환시킬게 없이 계속 돌아가다보면 속도가 느려지기 때문에 return값 설정
	}

	public int insert(MemberVO vo) {
		int rowCnt = 0;
		PreparedStatement pstmt = null;
		//(3 단계) Statement 객체 생성하기
		try {
			String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			//(4 단계) 바인딩 변수를 채운다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			//(5단계) SQL문을 실행하여 결과 처리
			rowCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCnt;
	}

	public void getClose() {
		try {
			// 반환
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}				
	}

	public MemberVO loginCheck(MemberVO vo) {
		MemberVO result = null;
		String sql = "select * from member where userid=? and pwd=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPwd());
			ResultSet rs = pstmt.executeQuery();
			// rs.next()가 true이면 id, pwd가 같은게 있음
			while(rs.next()) {
				String name = rs.getString("name");
				String userid = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				result = new MemberVO(name, userid, pwd, email, phone, admin);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
