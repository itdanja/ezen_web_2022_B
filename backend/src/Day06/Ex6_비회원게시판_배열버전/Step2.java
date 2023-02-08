package Day06.Ex6_비회원게시판_배열버전;

import java.util.Scanner;

public class Step2 { // class s
	public static void main(String[] args) { // main s 
		// step2 : 쓰기 페이지 실행되는 조건 
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		
		while( true ) { // 1. 무한루프 [ 종료조건 : -2 입력시 ]
			/* 게시물들이 출력되는 위치   */
			System.out.print(" 메뉴> 쓰기[-1]  나가기[-2]  : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				System.out.print(" 제목 : ");		String title = scanner.next();
				System.out.print(" 내용 : ");		String content = scanner.next();
				System.out.print(" 작성자 : ");	String writer = scanner.next();
				System.out.print(" 비밀번호 : ");	String password = scanner.next();
			} 
			else if( ch == -2 ) { break; }
		} // while e
	} // main e 
} // class e 
