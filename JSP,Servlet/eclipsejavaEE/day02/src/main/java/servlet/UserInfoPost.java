package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoPost
 */
@WebServlet("/userinfopost")
public class UserInfoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoPost() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] food = request.getParameterValues("food");
		String gender = request.getParameter("gender");
		String[] interested = request.getParameterValues("interested");
		
		out.print("<html><head><title>사용자 정보</title></head>");
		out.print("<body>");
		out.print("이름 : " + name + "<br>");
		int ages = Integer.parseInt(age) / 10;
		out.print("나이 : " + age + "(" + ages*10 + "대)" + "<br>");
		out.print("좋아하는 음식 : ");
		for (int i=0;i<food.length;i++) {
			out.print(food[i]);
			if (i < food.length-1) {
				out.print(", ");
			}
			else {
				continue;
			}
				
		}
		out.print("<br>");
		out.print("성별 : " + gender + "<br>");
		out.print("관심 분야 : ");
		for (int i=0;i<interested.length;i++) {
			out.print(interested[i]);
			if (i < interested.length-1) {
				out.print(", ");
			}
			else {
				continue;
			}
		}
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
