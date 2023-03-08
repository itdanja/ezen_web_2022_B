package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Info() {  super(); }
    
	// 1. 회원가입 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. ajax에게 데이터 요청 
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");		
		String mpwd = request.getParameter("mpwd");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		// 2. DTO 만들기 
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
			System.out.println( "dto : " + dto );
		// 3. Dao 호출하고 결과 받기 
		boolean result = MemberDao.getInstance().signtp(dto);
		// 4. 결과 응답하기 
		response.getWriter().print(result);
	}
    
    // 2. 로그인 / 회원1명 / 회원 여러명 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Dao 에게 모든 회원명단 요청후 저장 
		ArrayList<MemberDto> result = MemberDao.getInstance().getMemberList();	System.out.println( "result : " + result );
		// 2. JAVA객체 ---> JS객체 형변환 [ 서로 다른 언어 사용하니까 ]
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString( result );					System.out.println( "jsonArray : " + jsonArray );
		// 3. 응답 
		response.setCharacterEncoding("UTF-8");			// 응답 데이터 한글 인코딩 
		response.setContentType("application/json");	// 응답 데이터 타입
		response.getWriter().print(jsonArray);			// 응답 데이터 보내기
	}

	// 3. 회원 정보 수정 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 4. 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


















