package 과제.과제3.step3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		// * 입력객체 
		Scanner scanner = new Scanner(System.in);
		// * 리스트 선언 [ Book 객체를 여러개 저장할 리스트객체 선언  ]
		ArrayList<Book> bookList = new ArrayList<>(); // 가변길이 
		
		while( true ) { // while s 
			
			// * 출력  : 배열명[인덱스] vs 리스트명.get(인덱스)
			System.out.println("--------- 이젠 도서관 ----------");
			System.out.println("번호\t대여여부\t도서장르\t도서명");
			
			for( int i = 0 ; i<bookList.size() ; i++ ) { // i는 0부터 리스트내 마지막 인덱스까지 1씩증가 
				System.out.printf("%d \t %s \t %s \t %s \n" ,
						i , (bookList.get(i).state ? "가능" : "불가능") ,
						bookList.get(i).genre , bookList.get(i).name );
			} // for end 
			
			System.out.print( "1.대여 2.반납 3.등록 선택 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { // * 대여 
				System.out.println("--- 대여 페이지 ---");
				System.out.print(" 대여할 도서번호 : "); int bno = scanner.nextInt();
				
				if( bookList.get( bno ).state == true ) { // 만약에 입력한 도서인덱스의 도서상태가 true 대여 가능한 상태 
					System.out.println("[알림] 대여완료"); 
					bookList.get( bno ).state = false;	// 대여중으로 변경 
				}else {
					System.out.println("[알림] 대여 중인 도서 입니다. ");
				}
			}
			
			else if( ch == 2 ) { // * 반납
				System.out.println("--- 반납 페이지 ---");
				System.out.println(" 반납할 도서번호 : "); int bno = scanner.nextInt();
				if( bookList.get( bno ).state == false ) { // 만약에 입력한 도서인덱스의 도서상태가 false 반납가능한상태
					System.out.println("[알림] 반납완료");
					bookList.get( bno ).state = true ; // 대여가능 으로 변경 
				}else {
					System.out.println("[알림] 대여한 도서가 아닙니다.");
				}
			}
			
			else if( ch == 3 ) {
				System.out.println("--- 등록 페이지 ---");
				System.out.print("도서명 : ");	String inputName = scanner.next();
				System.out.print("장르 : ");		String inputGenre = scanner.next();
												boolean basicState = true;
				Book book = new Book();
				book.name = inputName; book.genre = inputGenre; book.state = basicState;
				bookList.add(book);
			}
			else { 	System.out.println("[알림] 알수 없는 행동 입니다."); }
		} // while e 
	} // main e 
} // class e 
 