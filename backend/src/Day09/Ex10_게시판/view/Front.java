package Day09.Ex10_게시판.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;

public class Front {
	
	// 1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	// 필드  : 입력 객체 [ 인스턴스 멤버 ]  
	private Scanner scanner = new Scanner(System.in);
	
	// 2. index 함수 
	public void index() {
		while( true ) {
			print_page(); // 출력함수 
			System.out.print(" 1.쓰기 : ");
			int ch = scanner.nextInt(); // 지역변수 
			if( ch == 1 ) { write_page(); } // 쓰기함수
		}
	}
	
	// 3. 쓰기 페이지 함수 
	private void write_page() {
		// 1. 입력받기 
		System.out.println(" --------- 글 쓰기 페이지 ------------");
		System.out.print("제목 : ");		String title = scanner.next();
		System.out.print("내용 : ");		String content = scanner.next();
		System.out.print("작성자 : ");	String writer = scanner.next();
		System.out.print("비밀번호 : ");	String password = scanner.next();
		
		Date date = new Date();	// 현재 날짜/시간 생성 객체
		int view = 0;	// 조회수는 0부터 시작 
		
		// 2. 컨트롤에게 입력받은 값 전달 후 결과를 result 에 저장 
		boolean result = 
		Bcontroller.getInstance().write(title, content, 
										writer, password, 
										date, view);
		// 3. 결과에 따른 출력 
		if( result ) {
			System.out.println(" [알림] 글쓰기 성공 ");
		}else {
			System.out.println(" [알림] 글쓰기 실패 ");
		}
	}
	
	// 4. 출력 페이지 함수 
	private void print_page() {
		
		ArrayList<Board> result
			= Bcontroller.getInstance().print();
		
		System.out.println("번호\t제목\t작성자\t조회수\t작성일");
		for( int i = 0 ; i< result.size() ; i++ ) {
			System.out.println( i+"\t" + result.get(i).toString() );
		}
	}
	
}


























