package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Step5 { // class s // step5 : 문자열 분리[split]해서 출력하기 
	public static void main(String[] args) throws Exception { // main s  
		Scanner scanner = new Scanner(System.in); 
		while( true ) {
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			byte[] inbytes = new byte[ 1000 ]; // 영 1바이트 , 한 3바이트
			int bytecount = fin.read( inbytes );	
			String fStr = new String( inbytes , 0 , bytecount );
			
			
			// 행 자르기 전 : fstr = "안녕하세요,자바글쓰기,유재석,1234\n호호호호호,자바글쓰기,강호동,4567\n"
			//* 행 기준 자르기 
			String[] boards = fStr.split("\n");	// 행 기준으로 분리 [ 만약에 게시물2개일때 2조각 ] 
			// 행 기준 자른후 : boards = { "안녕하세요,자바글쓰기,유재석,1234" , "호호호호호,자바글쓰기,강호동,4567" }
			
			System.out.println("------------------ 게시물 목록 ---------------------");
			System.out.printf( "%2s %10s%5s\n" , "번호" , "제목"  , "작성자" );
			//*[행마다] 열 기준 자르기
			for( int i = 0 ; i<boards.length ; i++ ) {
				// * 게시물 마다 열 자르기 
				String[] cols =  boards[i].split(","); // 4조각 
				String title = cols[0];		String content = cols[1];
				String writer = cols[2];	String password = cols[3];
				System.out.printf( "%2d %10s%5s\n" , i , title  , writer );
			}
			System.out.println("-----------------------------------------------");
			/*
			 	// boards = { "안녕하세요,자바글쓰기,유재석,1234" , "호호호호호,자바글쓰기,강호동,4567" } 
			 	for i = 0일때
			 			boards[0] = "안녕하세요,자바글쓰기,유재석,1234"
			 			cols = { "안녕하세요" , "자바글쓰기" , "유재석" ,"1234" } 
			 	for i = 1일때 
			  			boards[1] = "호호호호호,자바글쓰기,강호동,4567"
			  			cols = { "호호호호호" , "자바글쓰기" , "강호동" ,"4567" } 
			 */
			
			
			System.out.print(" 메뉴> 쓰기[-1]  나가기[-2]  : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				System.out.print(" 제목 : ");	String title = scanner.next();
				System.out.print(" 내용 : ");	String content = scanner.next();
				System.out.print(" 작성자 : ");	String writer = scanner.next();
				System.out.print(" 비밀번호 : ");	String password = scanner.next();
				
				String outStr = title+","+content+","+writer+","+password+"\n";
				
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true );
				fout.write( outStr.getBytes() ); // 스트림 : 바이트단위
				
			} 
			else if( ch == -2 ) { break; }
		} // while e
	} // main e 
} // class e 






