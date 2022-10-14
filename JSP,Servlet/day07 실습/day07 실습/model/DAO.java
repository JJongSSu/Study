package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	//JDBC를 위한 자료형 선언
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	// 커넥션을 위한 메소드 정의
	public String getConnection() { //
		
		String message = "fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/webdb?" +
						 "useUnicode=true&characterEncoding=utf-8";
			String uid = "root";
			String pass = "tbrs00002b";
			String sql = "select * from member";
			
			conn = DriverManager.getConnection(url, uid, pass);
			// 연결 성공
			message = "success";
		}
		catch(Exception e){
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
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			//(5단계) SQL문을 실행하여 결과 처리
			rowCnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return rowCnt;
	}

	public void getClose() {
		
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public MemberVO loginCheck(MemberVO vo) {
		MemberVO result = null;
		String sql = "select * from member where userid=? and pwd=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩 변수를 채운다.
		 	pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPwd());
			// SQL문을 실행하여 정보 출력
			rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				result = new MemberVO(name, id, pwd, email, phone, admin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	
	public ResultSet allSelect() {
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public List<MemberVO> allSelect2() {
		String sql = "select * from member";
		MemberVO result = null;
		List<MemberVO> memberList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String userid = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				result = new MemberVO(name, userid, pwd, email, phone, admin);
				memberList.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
		
	}

	
}
