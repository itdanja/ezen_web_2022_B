package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class Bcontroller {
	
	private ArrayList<Board> boardDB = new ArrayList<>();
	
	// 1. 글쓰기
	public boolean write( String title , String content ) {
		// 1. 유효성검사한다.[ 로그인이 안되어 있는경우 false ]
		if( Mcontroller.getInstance().getLogSession() == null ) {
			return false;
		}
		// 2. DB 저장 
			// 1. 객체화 [ 글작성 : 입력받은 데이터2개 , 초기값 0 , 로그인한 회원 객체 = 글쓴이 ]
		Board board = new Board( title, content, 0, Mcontroller.getInstance().getLogSession() );
			// 2. db에 저장
		boardDB.add(board);
			// 3. 멤버객체에 내가 쓴글 등록 
		Mcontroller.getInstance().getLogSession().getBoardlist().add(board);
		return true;
	}
	// 2. 글출력
	public ArrayList<Board> getList(){
		return null;
	}
	// 3. 글상세
	public Board getBoard( int bno ) {
		return null;
	}
	//4. 글삭제 
	public boolean delete( int bno ) {
		return true;
	}
	// 5.글수정
	public boolean update( int bno , String title , String content) {
		return true;
	}
}

/*

	5. 글쓰기 처리 
	인수 : title , content			반환 : true성공 , false실패 
	
	6. 글출력 데이터 반환
	인수 : x [ 페이징처리 , 검색처리 ]		반환 : 모든글이 담긴 arraylist<board>
	
	7. 글상세 데이터 반환  
	인수 : 글번호			반환 : 글 하나 board 
	*조회수 증가 
	
	8. 글삭제 처리 
	인수 : 글번호			반환 : true 성공 , false 실패
	
	9. 글수정 처리
	인수 : 글번호 , 새로운제목 , 새로운내용	반환 : true 성공 , false 실패 
	
	10.로그아웃 처리 
	인수 : x				반환 : true 성공 , false 실패 
*/
