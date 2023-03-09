package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 세션[Object]에 담겨진 회원아이디 호출 
		String mid = (String)request.getSession().getAttribute("login");
		// 2. 로그인한 회원의 정보 호출 [ 비밀번호 빼고 ] 
		MemberDto result =  MemberDao.getInstance().getMember( mid );
			System.out.println( " result : " + request );
			// JAVA객체 --> JS 객체 변환 
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
			System.out.println( " json : " + json );
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( json );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX에게 데이터 요청
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		// 2. DAO 호출해서 요청데이터를 보내서 결과 얻기 
		boolean result = MemberDao.getInstance().login( mid , mpwd );
		if( result == true ) { // 만약에 로그인 성공했으면 
			// 로그인 세션 만들기
				// request.getSession() : 서버[톰캣] 내 세션 객체 호출 
				// setAttribute( "key" , value );	// 서버[톰캣] 내 세션객체에 속성[데이터] 추가 
			// 세션객체 에 'login' 이름으로 로그인 성공한 데이터 저장 
			request.getSession().setAttribute( "login", mid );
		}
		// 3. Dao 받은 결과를 AJAX에게 전달 
		response.getWriter().print(result);
	}
	
	
	
	
	
	
	

}













