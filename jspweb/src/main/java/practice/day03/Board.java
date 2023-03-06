package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Board() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 1. 등록 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 한글 인코딩 
		request.setCharacterEncoding("UTF-8");
		// 2. 매개변수 요청 [ AJAX data속성에서 보내준 매개변수 이름 
		String content = request.getParameter("content");
			System.out.println( " content : " + content );
		String writer = request.getParameter("writer");
			System.out.println( " writer : " + writer );
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
