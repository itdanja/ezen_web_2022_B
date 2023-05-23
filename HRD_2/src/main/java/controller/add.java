package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		String sno = request.getParameter("sno"); // 1. 매개변수[form name 동일 ] 요청 
		int ekor = Integer.parseInt( request.getParameter("ekor"));
		int emath = Integer.parseInt(request.getParameter("emath"));
		int eeng = Integer.parseInt(request.getParameter("eeng"));
		int ehist = Integer.parseInt(request.getParameter("ehist"));
		Dto dto = new Dto(sno, ekor, emath, eeng, ehist); // 2. dto 
		Dao dao = new Dao();  boolean result =  dao.add(dto); // 3. dao 
		if( result ) { response.sendRedirect("/HRD_2/add.jsp"); } // 4. 결과에 따른 페이지 응답
		else { }
	}
}





























