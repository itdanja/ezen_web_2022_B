package Day06;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex3_문자열2 {
	public static void main(String[] args) throws Exception {
		
		while( true ) { // *무한반복
			// 1. 문자열 입력받기 
			Scanner scanner = new Scanner( System.in );		// 1. 입력객체 
			String input = scanner.nextLine()+"\n";			// 2. 입력받은 문자열을 변수에 저장 
			// 2. 문자열 파일에 저장 [ 자바외 키보드/파일/네트워크 등등 통신할때 무조건 바이트단위 ]
			FileOutputStream fout = new FileOutputStream("c:/java/test.txt" , true);
			fout.write( input.getBytes() );
		}
	}
}
/*
 * 
	// FileOutputStream( "파일경로" ) : 파일 쓰기 클래스 
		// FileOutputStream( "파일경로" ) : 파일 새로 쓰기 
		// FileOutputStream( "파일경로" , true ) : 파일 이어 쓰기 
			// .write( 바이트배열 ) : 
	// 문자열.getBytes() : 해당 문자열을 바이트배열 반환
 */






