package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Step3 { // class s // step3 : 입력된 데이터를 파일처리 [ 영구저장 ]
	public static void main(String[] args) throws Exception { // main s  // 2. 예외처리 던지기
		Scanner scanner = new Scanner(System.in); // * 입력객체
		while( true ) {
			System.out.print(" 메뉴> 쓰기[-1]  나가기[-2]  : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				System.out.print(" 제목 : ");		String title = scanner.next();
				System.out.print(" 내용 : ");		String content = scanner.next();
				System.out.print(" 작성자 : ");	String writer = scanner.next();
				System.out.print(" 비밀번호 : ");	String password = scanner.next();
				
				// 2.  , : 열 구분선[데이터구분]  		\n : 행 구분선[게시물구분] 
				String outStr = title+","+content+","+writer+","+password+"\n";
				
				// 1. 파일처리 객체 생성 ( "파일경로" , true );
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true );
				fout.write( outStr.getBytes() );
				
			} 
			else if( ch == -2 ) { break; }
		} // while e
	} // main e 
} // class e 






