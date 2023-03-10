package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Find
 */
@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받은 타입 요청 
		String type = request.getParameter("type");
		String result = null; // * 보낼 결과 
		if( type.equals("1") ) { // 아이디찾기 
			String memail = request.getParameter("memail");	// 1. 이메일 요청
			result = MemberDao.getInstance().findid( memail );
		}else if( type.equals("2") ) { // 비밀번호찾기 
			String mid = request.getParameter("mid");
			String memail = request.getParameter("memail");
			result = MemberDao.getInstance().findpwd( mid , memail );
		}
		response.getWriter().print( result ); // 3.
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
