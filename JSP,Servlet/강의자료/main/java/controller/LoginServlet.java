package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.MemberVO;

@WebServlet("/loginService")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 정보 가져오기
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//로그인 정보를 MemberVO로 묶기->MemberVO 객체 생성->setter() 이용한 값저장
		//객체 생성하면서 값 세팅 하기
		MemberVO vo= new MemberVO(userid, pwd);

		//DAO 객체 이용하여 확인
		DAO dao = new DAO();
		//DB연결
		dao.getConnection();
		
		//데이터 처리
		MemberVO result = dao.loginCheck(vo);
		//해당되는 로그인 정보가 있는지 판단
		if(result != null) {
			//로그인 성공
			//세션객체에 멤버정보 저장하고 -->success.jsp
			HttpSession session = request.getSession();
			session.setAttribute("member", result);
			response.sendRedirect("success.jsp");
			
		}else {
			//로그인 실패 -> login.jsp
			response.sendRedirect("login.jsp");
		}
		
		//DB 자원 반환
		dao.getClose();
	}

}








