package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 1. 한글인코딩
		String v_jumin = request.getParameter("v_jumin"); // 2. 매개변수 요청 
		String v_name = request.getParameter("v_name"); 
		String m_no = request.getParameter("m_no"); 
		String v_time = request.getParameter("v_time"); 
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm"); 
		Dto dto = new Dto(m_no, v_jumin, v_name, v_time, v_area, v_confirm); // 3. Dto 생성
		Dao dao = new Dao(); // 4. Dao 처리 
		boolean result = dao.vote( dto );
		if( result ) response.sendRedirect("/HRD_3/index.jsp"); // 5. 성공시 페이지 전환
		else response.sendRedirect("/HRD_3/vote.jsp");
	}
}





















