package controller.board;

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

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;


/**
 * Servlet implementation class Boardinfo
 */
@WebServlet("/board/info") // !: 프로젝트내 동일한 서블릿주소 있을경우 서버자체 안켜짐
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Boardinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") );
		if( type == 1 ) { // 1. 전체 출력 
			
			// ------------- page 처리 --------------- //
			// 1. 현재페이지[요청] , 2.페이지당 표시할게시물수 3.현재페이지[ 게시물시작  ]
			int page = Integer.parseInt( request.getParameter("page") );
			int listsize = 3;
			int startrow = (page-1)*listsize; // 해당 페이지에서의 게시물 시작번호
			// ------------- page 버튼 만들기 ------------ //
			// 1. 전체페이지수[ 총게시물레코드수/페이지당 표시수 ] 2. 페이지 표시할 최대버튼수 3. 시작버튼/마지막버튼 번호 
			int totalsize = BoardDao.getInstance().gettotalsize();
			int totalpage = totalsize % listsize == 0 ? 	// 만약에 나머지가 0 이면 
							totalsize/listsize :  totalsize/listsize+1;
			int btnsize = 5; // 최대 페이징버튼 출력수
			int startbtn = ( (page-1) / btnsize ) * btnsize +1 ; 
			int endbtn = startbtn + (btnsize-1);
			// * 단 마지막버튼수가 총페이지수보다 커지면 마지막버튼수 총페이지수로 대입 
			if( endbtn > totalpage ) endbtn = totalpage;
			
			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList( startrow , listsize );
			
			// page Dto 만들기 
			PageDto pageDto 
			= new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
			
			// java 형식 ---> js형식 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray =  mapper.writeValueAsString( pageDto );
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("applcation/json");
			response.getWriter().print( jsonArray );
			
		}else if( type == 2 ) { // 2. 개별 출력 
			int bno = Integer.parseInt( request.getParameter("bno") ) ;	System.out.println("bno:"+bno);
			// Dao 처리 
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			// 형변환 처리
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( result );
			// 응답 처리
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print( json );
		}

	}
	/*
 	총 게시물수 = 10		, 페이지당 표시할 게시물수 = 3
 	총 레코드수 = 10	총 레코드의 인덱스 : 0~9
 	1. 총 페이지수 = 012 , 345 , 678 , 9	--> 4
 			
 			총 레코드수/페이당표시게시물수
 				1. 나머지가 없으면 => 몫			9/3 -> 3페이지
 				2. 나머지가 있으면 => 몫 + 1		10/3 -> 4페이지
 			
	2. 페이지별 게시물시작 번호 찾기 
			1페이지 요청 -> (1-1)*3	=> 0
			2페이지 요청 -> (2-1)*3	=> 3
			3페이지 요청 -> (3-1)*3	=> 6
	3. 시작버튼 , 마지막버튼 수 
		7페이지	btnsize = 5
				시작번호패턴 : 1 6 11 16 21
		1페이지 -> 12345
		2페이지 -> 12345
		3페이지 -> 12345
		4페이지 -> 12345
		5페이지 -> 12345
		6페이지 -> 678910	--> 67
		7페이지 -> 678910	--> 67
		
		7페이지	btnsize = 3
				시작번호패턴 : 1 4 7 10
		1페이지 -> 123
		2페이지 -> 123
		3페이지 -> 123
		4페이지 -> 456
		5페이지 -> 456
		6페이지 -> 456
		7페이지 -> 7
		
 			1페이지 	: 1-1 / 5 	*5 +1			-> 	0*5+1	 	1 
  			2페이지	: 2-1 / 5	*5 +1			->	0*5+1		1
  			3페이지 	: 3-1 / 5	*5 +1			->  0*5+1		1
  			4페이지	: 4-1 / 5	*5 +1			->	0*5+1		1
  			5페이지	: 5-1 / 5	*5 +1			->  0*5+1		1
  			6페이지	: 6-1 / 5 	*5 +1			->  1*5+1 		6
  			7페이지	: 7-1 / 5	*5 +1			->	1*5+1		6
 */

		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드 
		// 1. 업로드할 파일의 저장 위치[경로]
			// 클라이언트[유저] ------ x --->  git[ 내프로젝트 ]
			//			   ------ o ---->  서버[ 배포된프로젝트 ]
		// 2. 경로 찾기 
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println( "path : "+ path );
		// 3. 파일 복사 [ 입력받은[file] 대용량 바이트 복사하기 ]
		MultipartRequest multi = new MultipartRequest(
				request ,  path ,  1024*1024*10 , "UTF-8" ,
				new DefaultFileRenamePolicy() );
			System.out.println( "multi : " + multi );
		// ---------- 확인 ----------
			// request.getParameter("객체명의 필드명")
			// multi.getParameter("form 하위 태그의 name명");
		int cno = Integer.parseInt( multi.getParameter("cno") ) ;		System.out.println("cno:"+cno);
		String btitle = multi.getParameter("btitle");					System.out.println("btitle:"+btitle);
		String bcontent = multi.getParameter("bcontent");				System.out.println("bcontent:"+bcontent);
		String bfile = multi.getFilesystemName("bfile");				System.out.println("bfile:"+bfile);
						// getFilesystemName : input 실제 파일이름
		// ---------- 확인 ----------
			// 1. 회원제게시판[ 로그인된 회원의 mno 필요!]
			String mid = 
				(String)request.getSession().getAttribute("login");
			// 2. mid ---> mno ( Dao )
			int mno = MemberDao.getInstance().getMno(mid);
			// 3. 만약에 회원번호가 존재하지 않으면 글쓰기 불가능 
			if( mno < 1 ) { response.getWriter().print("false"); }
			
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno); // Dto 
			System.out.println( "dto : " + dto );
		boolean result = BoardDao.getInstance().bwrite(dto); // DAO
		// 응답 
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}










