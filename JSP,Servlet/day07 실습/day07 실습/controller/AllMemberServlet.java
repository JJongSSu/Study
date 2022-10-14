package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.MemberVO;


@WebServlet("/allSelect")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 가져오기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		// DAO 객체 이용하여 확인
		DAO dao = new DAO();
		dao.getConnection();
		
		PrintWriter out = response.getWriter();
		
		out.print("<table width='800' border='1'>");
		out.print("<tr>");
		out.print("<th>이름</th>");
		out.print("<th>아이디</th>");
		out.print("<th>암호</th>");
		out.print("<th>이메일</th>");
		out.print("<th>전화번호</th>");
		out.print("<th>권한(1:관리자, 0:일반회원)</th>");
		out.print("</tr>");
		
		
		for(MemberVO mb : dao.allSelect2()) {
			out.print("<tr>");
			out.print("<td>" + mb.getName() + "</td>");
			out.print("<td>" + mb.getUserid() + "</td>");
			out.print("<td>" + mb.getPwd() + "</td>");
			out.print("<td>" + mb.getEmail() + "</td>");
			out.print("<td>" + mb.getPhone() + "</td>");
			out.print("<td>" + mb.getAdmin() + "</td>");
			out.print("</tr>");
		}

		out.print("</table><p><p>");
		
		out.print("<table width='800' border='1'>");
		out.print("<tr>");
		out.print("<th>이름</th>");
		out.print("<th>아이디</th>");
		out.print("<th>암호</th>");
		out.print("<th>이메일</th>");
		out.print("<th>전화번호</th>");
		out.print("<th>권한(1:관리자, 0:일반회원)</th>");
		out.print("</tr>");
		
		ResultSet rs = dao.allSelect();
		
		try {
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("name") + "</td>");
				out.print("<td>" + rs.getString("userid") + "</td>");
				out.print("<td>" + rs.getString("pwd") + "</td>");
				out.print("<td>" + rs.getString("email") + "</td>");
				out.print("<td>" + rs.getString("phone") + "</td>");
				out.print("<td>" + rs.getInt("admin") + "</td>");
				out.print("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.print("</table>");
		
		dao.getClose();
	}

}
