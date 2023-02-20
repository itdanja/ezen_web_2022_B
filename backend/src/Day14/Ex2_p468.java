package Day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_p468 {
	public static void main(String[] args) {
		// 1. Class.forName("패키지명.클래스")
			// 일반예외 : 컴파일전에 예외 확인
		try {
			Class.forName("java.lang.String"); // 클래스 여부 찾기
			System.out.println("java.lang.String 클래스 존재");
		}
		catch( ClassNotFoundException e ) { e.printStackTrace(); }
		// ----------------
		System.out.println();
		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 클래스 존재");
		}
		catch( ClassNotFoundException e ) { e.printStackTrace(); }
		
		// 2. 
			// 배열 : 타입[] 배열명 = { 데이터 , 데이터 , 데이터 }
		String[] array = {"100","1oo" };
			// 배열 for : 인덱스 : 0  , 길이 : 1
		for( int i = 0 ; i<=array.length ; i++ ) {
			try {
				int value = Integer.parseInt( array[i] );
					// Integer.parseInt( 문자열 ) -> 정수형 
					// 예외발생 : "100" -> 100 가능 / "1oo" -> 불가능 
				System.out.println( " array["+ i +"] " +  value );
			}
			catch( NumberFormatException e ) {
				System.out.println("숫자로 변환할수 없음 : "+e);
			}
			catch( ArrayIndexOutOfBoundsException e ) {
				System.out.println("인데스 초과 : "+e);
			}
			catch( Exception e ) { // 예외클래스 중에서 최상위 클래스는 가장 아래에 작성 
				System.out.println("예외 발생 : "+ e);
			}
		}
		
		// 3. 
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				int ch = scanner.nextInt();
			}catch( Exception e  ) {
				System.out.println(" 잘못된 입력입니다. ");
			}
		}
		
		
		
	}
}







