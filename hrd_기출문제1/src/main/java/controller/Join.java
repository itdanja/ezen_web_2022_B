package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		int city = Integer.parseInt( request.getParameter("city"));
		
		
		MemberDto dto = new MemberDto(0, custname, phone, address, joindate, grade, city);
		
		Dao dao = new Dao();
		boolean result = dao.join(dto);
		
		// 성공시 다시 가입 페이지 이동 
		if( result ) {
			response.sendRedirect("/hrd_exam1/join.jsp");
		}
	}

}










