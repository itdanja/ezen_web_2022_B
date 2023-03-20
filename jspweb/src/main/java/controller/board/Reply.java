package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
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
		// 1. 
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt( request.getParameter("bno") );
		int mno = MemberDao.getInstance().getMno( 
				(String)request.getSession().getAttribute("login")
				);
		String rcontent = request.getParameter("rcontent");
		// 2. 
		ReplyDto dto = new ReplyDto(rcontent, mno, bno);
			System.out.println( "dto:"+ dto );
		// 3. 
		boolean result = BoardDao.getInstance().rwrite(dto);
		// 4.
		response.getWriter().print(result);
		
		
	}

}












