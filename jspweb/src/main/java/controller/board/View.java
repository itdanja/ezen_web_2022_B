package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;

/**
 * Servlet implementation class View
 */
@WebServlet("/board/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 타입과 게시물번호 요청 
		int type = Integer.parseInt( request.getParameter("type") );	System.out.println( type );
		int bno = Integer.parseInt( request.getParameter("bno") );		System.out.println( bno );
		
		/*
		 	- 하루에 한번씩 조회수 또는 좋아요수 또는 싫어요수 증가 가능 
		 	- 회원별 vs pc별
		 	- 세션 사용  
		 */
		// 1. pc 네트워크 식별자[ ip ]
			// 1. java에서 현재 요청한 클라이언트의 ip 확인 
		String ip = request.getRemoteAddr();
			System.out.println( "ip: " + ip);
			
		// 4. 만약에 기존 세션이 없으면 증가가능 있으면 증가불가
		Object o = request.getSession().getAttribute(type + ip + bno );
		if( o == null ) { // 세션[ bno+type+ip ]이 생성된 적이 없다.
			// 2. 세션 생성 [ bno+type+ip ]
			request.getSession().setAttribute( type + ip + bno , 1 );
			// 3. 세션 생명주기[ 생명주기 지나면 자동으로 메모리 삭제 / 초 단위 ]
				// 1. 세션 초기화 되는 기준 
					// 1. 서버 끄면 2.서버 다시 켰을때 3.MaxInactiveInterval 설정한 시간이 지났을떄
					// 4. .invalidate() 5.setAttribute( "세션명" , null )
			request.getSession().setMaxInactiveInterval( 60*60*24 ); // 하루
			
			// 2. Dao 처리 
			BoardDao.getInstance().bIncrease( type , bno );
		} // if end 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
