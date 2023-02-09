package 과제.과제3.step1;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		// * 입력객체 
		Scanner scanner = new Scanner(System.in);
		
		while( true ) { // while s 
			
			System.out.print( "1.대여 2.반납 3.등록 선택 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				System.out.println("--- 대여 페이지 ---");
			}
			else if( ch == 2 ) {
				System.out.println("--- 반납 페이지 ---");
			}
			else if( ch == 3 ) {
				System.out.println("--- 등록 페이지 ---");
			}
			else {
				System.out.println("[알림] 알수 없는 행동 입니다.");
			}
		} // while e 
	} // main e 
} // class e 
 