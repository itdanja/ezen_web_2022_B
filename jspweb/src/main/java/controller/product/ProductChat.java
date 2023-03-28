package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;

/**
 * Servlet implementation class ProductChat
 */
@WebServlet("/product/chat")
public class ProductChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int pno = Integer.parseInt( request.getParameter("pno") );
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("login") );
		//
		ArrayList<ChatDto> result = ProductDao.getInstance().getChatList(pno, mno);
		ObjectMapper mapper = new ObjectMapper();	String jsonArray = mapper.writeValueAsString(result);
		//
		response.setCharacterEncoding("UTF-8"); response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 1
		String 쪽지내용	= request.getParameter("ncontent");
		int 제품번호 		= Integer.parseInt(  request.getParameter("pno") );
		int 보낸회원번호 	= MemberDao.getInstance().getMno(
							(String)request.getSession().getAttribute("login") );
		int 받는회원번호 	= Integer.parseInt( request.getParameter("tomno") );
		// 2
		ChatDto dto = new ChatDto(0, 쪽지내용, null, 제품번호, 보낸회원번호, 받는회원번호);	System.out.println( "dto : " + dto );
		// 3
		boolean result = ProductDao.getInstance().setChat( dto );
		response.getWriter().print(result);
	}
}







