package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Step4 { // class s // step4 : 파일에 있는 문자열 가지고 오기 
	public static void main(String[] args) throws Exception { // main s  
		Scanner scanner = new Scanner(System.in); 
		while( true ) {
			// 현재 파일에 존재하는 모든 문자열 호출 
			// 1. 파일 입력 [
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			byte[] inbytes = new byte[ 1000 ]; 			// 영문 1바이트 , 한글 3바이트 
			fin.read( inbytes );						// 2. 읽어온 바이트를 바이트배열에 저장 
			String boardlist = new String( inbytes ) ; // 3. 바이트배열 --> 문자열 변환 
			
			System.out.print(" 메뉴> 쓰기[-1]  나가기[-2]  : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				System.out.print(" 제목 : ");		String title = scanner.next();
				System.out.print(" 내용 : ");		String content = scanner.next();
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






