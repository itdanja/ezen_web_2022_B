package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Point
 */
@WebServlet("/point")
public class Point extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Point() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mpcomment = request.getParameter("mpcomment");
		int mpamount = Integer.parseInt( 
				request.getParameter("mpamount") );
		int mno = Integer.parseInt(
				request.getParameter("mno") );
		// 
		boolean result = MemberDao.getInstance().
					setPoint(mpcomment, mpamount, mno);
		
		response.getWriter().print(result);
	}

}







