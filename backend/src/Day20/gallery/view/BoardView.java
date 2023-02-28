package Day20.gallery.view;

import java.util.Scanner;

import Day20.gallery.controller.MController;

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
			// 모든 갤러리 출력
			System.out.print(" -1:로그아웃 / 0:갤러리추가 / 이동할 갤러리 번호 선택 :  ");
			int ch = scanner.nextInt();
			if( ch == -1 ) { 
				MController.getInstance().setLoginSession(0); // 로그인세션 초기화 
				System.out.println("[로그아웃] 안녕히 가세요! ");
				break; 
			}
			else if( ch == 0 ) { }
			else if( ch > 0 ) {}
		}
	}
	
	
}
