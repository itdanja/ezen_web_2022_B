package Day09.Ex10_게시판.view;

import java.util.Scanner;

public class Front {
	
	// 1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	// 필드  : 입력 객체 
	private Scanner scanner = new Scanner(System.in);
	
	// 2. index 함수 
	public void index() {
		while( true ) {
			System.out.print(" 1.쓰기 : ");
			int ch = scanner.nextInt(); // 지역변수 
			if( ch == 1 ) { write_page(); }
		}
	}
	
	// 3. 쓰기 페이지 함수 
	private void write_page() {
		System.out.println(" --------- 글 쓰기 페이지 ------------");
	}
	
	// 4. 출력 페이지 함수 
	private void print_page() {
		
	}
	
}




