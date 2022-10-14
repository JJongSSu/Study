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
	private PreparedStatement pstmt =  null;
	private ResultSet rs = null;
	//private Statement stmp = null;
	// 커넥션을 위한 메소드 정의
	public String getConnection(){
		String message = "fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/webdb?"
				      +"useUnicode=true&characterEncoding=utf-8";
		String uid = "root";
		String pass = "tbrs00002b";
			conn = DriverManager.getConnection(url, uid, pass);
			//연결 성공
			message = "success";
			//데이타 처리
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return message;
	}

	public int insert(MemberVO vo) {
		int rowCnt = 0;
		try {
			String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			//(4 단계) 바인딩 변수를 채운다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUesrid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			//(5단계) SQL문을 실행하여 결과 처리
			rowCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCnt;
	}

	public void getClose() {
		try {
			//자원 반환
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public MemberVO loginCheck(MemberVO vo) {
		MemberVO result = null;
		String sql = "select * from member where userid=? and pwd=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//(4 단계) 바인딩 변수를 채운다.
			pstmt.setString(1, vo.getUesrid());
			pstmt.setString(2, vo.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				result = new MemberVO(name, id, pwd, email, phone, admin);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}








