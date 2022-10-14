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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		//MemberVO에 넣기
		MemberVO vo = new MemberVO(name, userid, pwd, email, phone, admin);
		System.out.println(vo);
		
		//DB연결
		DAO dao = new DAO();
		String message = dao.getConnection();
		System.out.println(message);
		
		//자료를 DB에 저장
		int result = dao.insert(vo);
		if(result>0) {
			System.out.println(result);
			request.setAttribute("message", "회원가입에 성공했습니다.");
		}
		else {
			request.setAttribute("message", "회원가입에 실패했습니다. 다시 입력해 주세요");
		}
		
		// 자원 반환
		dao.getClose();
		
		RequestDispatcher dispt = request.getRequestDispatcher("main.jsp");
		dispt.forward(request, response);
	}

}
