package 과제.과제3.step2;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		// * 입력객체 
		Scanner scanner = new Scanner(System.in);
		// * 리스트 선언 [ Book 객체를 여러개 저장할 리스트객체 선언  ]
		ArrayList<Book> bookList = new ArrayList<>(); // 가변길이 
		
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
				// 1. 입력받기 --> 변수 3개 [ 입력2[String,String] , 기본1[boolean] ]
				System.out.println("도서명 : ");	String inputName = scanner.next();
				System.out.println("장르 : ");	String inputGenre = scanner.next();
												boolean basicState = true;
				// 2. 서로 다른 자료형의 변수들을 하나의 자료형으로 만들자 [ 클래스 ] 
						// String , String , boolean --> Book 객체로 묶자!
				Book book = new Book();
				book.name = inputName; book.genre = inputGenre; book.state = basicState;
				// 3. 배열 or 리스트 저장 
				bookList.add(book);
			}
			else {
				System.out.println("[알림] 알수 없는 행동 입니다.");
			}
		} // while e 
	} // main e 
} // class e 
 