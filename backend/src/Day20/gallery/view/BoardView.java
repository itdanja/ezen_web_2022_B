package Day20.gallery.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.controller.BController;
import Day20.gallery.controller.MController;
import Day20.gallery.model.Dto.CategortDto;
import 과제.과제4_싱글톤.controller.Bcontroller;

public class BoardView {
	
	private static BoardView boardView = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() { return boardView;}
	
	private Scanner scanner = new Scanner(System.in); 
	
	// 1. 게시물 모든 게시물
	public void index() {
		while( true ) {
			System.out.println(" =============== 이젠 갤러리 ============== ");
			// 최신 게시물 3개 출력
			
			categoryPrint(); // 모든 갤러리 출력
			
			System.out.print(" -1:로그아웃 / 0:갤러리추가 / 이동할 갤러리 번호 선택 :  ");
			int ch = scanner.nextInt(); 
			if( ch == -1 ) { 
				MController.getInstance().setLoginSession( 0 ); // 로그인세션 초기화 
				System.out.println("[로그아웃] 안녕히 가세요! ");
				break;  // while 탈출
			}
			else if( ch == 0 ) { categoryAdd(); }
			else if( ch > 0 ) {}
		}
	}
	// 2. 카테고리=갤러리 추가 
	public void categoryAdd() {
		System.out.println(" =============== 갤러리 추가 ============== ");
		System.out.print(" 추가할 갤러리 이름 : "); 
		scanner.nextLine(); // * scanner.nextLine() 에러 방지
		String cname = scanner.nextLine();
		// 컨트롤에게 입력받은 갤러리명 전달하고 컨트롤에게 성공여부 반환 받아 저장 
		boolean result 	= BController.getInstance().categoryAdd( cname ); 
		// 반환 여부에 따른 출력 
		if( result ) { System.out.println("[등록성공] 갤러리가 추가 되었습니다. ");}
		else { System.out.println("[등록실패] 관리자에게 문의 ");}
	}// end 
	// 3. 모든 카테고리=갤러리[ 갤러리1개 = dto 1개 / 갤러리여러개 = dto 여러개 = 배열 혹은 리스트 ] 호출 
	
	public void categoryPrint() {
		//1. 컨트롤에게 모든 카테고리 요청후 반환된 리스트를 에 담기 
		ArrayList<CategortDto> clist =  BController.getInstance().categoryPrint();
//		// 2. 출력1
//		for( int i = 0 ; i<clist.size() ; i++ ) {
//			System.out.println( clist.get(i).getCno() +" - "+ clist.get(i).getCname() );
//		}
		// 2. 출력2 : 향상된 for문 
		int count = 0;	// 반복횟수 저장하는 함수 
		for( CategortDto dto : clist ) {
			System.out.print( dto.getCno() +" - "+ dto.getCname() +"\t" );
			count++; // for 반복 할때 마다 1씩 증가 
			if( count % 4 == 0 )System.out.println(); // 4개 마다 줄바꿈 
		}
		System.out.println();
	}
}






















