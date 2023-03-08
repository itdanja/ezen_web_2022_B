package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Info() {  super(); }
    
	// 1. 회원가입 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ------------ 첨부파일 있을때 --------------//
		/*
		 	request는 첨부파일(대용량) 에 대한 요청이 불가능 --> 외부 라이브러리  cos.jar
		 	1. 프로젝트 build path 에 cos.jar 추가
		 	2. 프로젝트 WEB-INF -> lib -> cos.jar 추가 
		  	---------
		  	MultipartRequest 클래스 제공 
		  		1. 요청방식 : HTTP request
		  		2. 저장폴더 : 1.프로젝트[git] 2.서버[워크스페이스] // 수업에서는 서버 에 올림 
		  			서버폴더 경로 찾기 : request.getSession().getServletContext().getRealPath("(webapps생략)폴더명");
		  		3. 첨부파일 허용 범위 용량[ 바이트단위 ]
		  		4. 첨부파일 요청 한글 인코딩 
		  		5. 첨부파일 파일명 중복일경우 뒤에 자동 붙임 
		  	--------
		  	용량 
		  		1bit : 0 , 1 
		  		1byte : 01010101	8bit --> 1byte 
		  		1kbyte : 1024byte 	--> 1KB
		  		1MByte : 1024kb 	--> 1MB
		  		1GByte : 1024mb		--> 1GB
		  		
		 */
		// * 현재 서버의 배포된 프로젝트내 폴더 경로 찾기 
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println( uploadpath );
		
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				uploadpath , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		
		// 
		String mid = multi.getParameter("mid");	System.out.println( mid );
	
		
		// ------------ 첨부파일 없을떄 --------------//
		/*
		 
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
		
		*/
		
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


















