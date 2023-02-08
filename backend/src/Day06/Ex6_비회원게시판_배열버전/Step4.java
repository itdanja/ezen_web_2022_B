package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Step4 { // class s // step4 : 파일에 있는 문자열 가지고 오기 
	public static void main(String[] args) throws Exception { // main s  
		Scanner scanner = new Scanner(System.in); 
		while( true ) {
			// 현재 파일에 존재하는 모든 문자열 호출 
			// 1. 파일입력 클래스 객체 생성 ( 파일경로 ) 
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			// 2. 읽어온 바이트를 저장하기 위해 바이트배열 1000바이트 미리 생성
			byte[] inbytes = new byte[ 1000 ]; // 영 1바이트 , 한 3바이트
			// 3. .read( ) 메소드를 이용한 파일 읽기 [ * 읽은 바이트를 바이트배열 저장 ] 
				// inbytes : 읽어온 바이트를 배열에 저장 
				// bytecount : 읽어온 바이트의 개수를 변수에 저장  
			int bytecount = fin.read( inbytes );	
			// 4. 바이트배열 ---> 문자열
				// new String("유재석");
				// new String( 바이트배열 );	new String( 바이트배열 , 시작인덱스 , 마지막인덱스 );
			String fStr = new String( inbytes , 0 , bytecount );
			
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






