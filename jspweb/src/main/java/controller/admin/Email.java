package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

/**
 * Servlet implementation class Email
 */
@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email() {
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
		// 1. 받을 회원 이메일 요청 
		String memail = request.getParameter("memail");	System.out.println( "memail : "+ memail );
		// 2. 인증코드 만들기 
		String auth = "";
		
		for( int i = 0 ; i<6 ; i++ ) {	// 6자리 난수 생성 
			Random random = new Random(); // 랜덤 객체 
			auth += random.nextInt(10);	// 0~9 사이의 정수 생성 
		};System.out.println( "auth : " + auth );
		
		// 3. 인증코드를 받는사람의이메일 에게 보내기 
	 	boolean result = new MemberDto().sendEmail(memail, auth);
	 	if( result ) { // 메일 전송 성공시 인증코드 보내기
	 		response.getWriter().print( auth ); 
	 	}else { // 4. 메일 전송 실패시 false;
	 		response.getWriter().print( result );
	 	}
	
	}

}
// 2.
/*
 	1.
 		new MemberDto().sendEmail(memail, auth);
 	2.
		MemberDto dto = new MemberDto();
		dto.sendEmail(memail, auth);
*/


/*
	-SMTP(간이 메일 전송 프로토콜) : Simple Mail Transfer Protocol
	-메일 서버( 네이버,구글,다음 )에게 우편 전송 
	- JAVA MAIL 라이브러리 추가 [ java-mail , java-activation ] 
*/









