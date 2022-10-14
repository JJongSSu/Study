package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.MemberVO;


@WebServlet("/joinService")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 클라이언트에서 보내는 데이터 가져오기
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		//2. MemberVO에 넣기
		MemberVO vo = new MemberVO(name, userid, pwd, email, phone, admin);
		System.out.println(vo.toString());
		
		// DB 연결
		DAO dao = new DAO();
		// DB 연결 위한 메소드 호출
		String message = dao.getConnection();
		System.out.println("message: " + message);
		//자료를 DB 저장 데이터 처리
		int result = dao.insert(vo);
		if(result>0) {
			System.out.println("result: " + result);
			request.setAttribute("message", "회원가입 성공");
		}
		else {
			request.setAttribute("message", "회원가입 실패");
		}
		//자원 반환
		dao.getClose();
		RequestDispatcher dispt = request.getRequestDispatcher("main.jsp");
		dispt.forward(request, response);
	}

}
