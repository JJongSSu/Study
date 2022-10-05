package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LabJoinTable
 */
@WebServlet("/labjointable")
public class LabJoinTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabJoinTable() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		String pw2 = request.getParameter("pwd2");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String birthday = request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String firstcolor = request.getParameter("firstcolor");
		String writers = request.getParameter("writers");
		
		out.print("<html><head><title>사용자 정보</title></head>");
		out.print("<body>");
		out.print("아이디 : "+id+"<br>");
		out.print("비밀번호 : "+pw+"<br>");
		if(!pw2.equals(pw)) {
			out.print("비밀번호가 일치하지 않습니다. <br>");
		}
		out.print("성별 : " + gender + "<br>");
		out.print("혈액형 : " + blood + "<br>");
		out.print("생일 : " + birthday + "<br>");
		out.print("취미 : ");
		for (int i=0;i<hobby.length;i++) {
			out.print(hobby[i]);
			if (i < hobby.length-1) {
				out.print(", ");
			}
			else {
				continue;
			}
		}
		out.print("<br>");
		out.print("좋아하는색  : " + firstcolor + "<br>");
		out.print("<div style='width:100px;height:100px;background:"+firstcolor+";'></div>");
		out.print("남기고 싶은 말 : " + writers + "<br>");
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
