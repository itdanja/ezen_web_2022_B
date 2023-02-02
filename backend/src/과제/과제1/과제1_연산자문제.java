package 과제.과제1;

import java.util.Scanner; // Scanner 클래스 호출 

public class 과제1_연산자문제 { // c s 
	public static void main(String[] args) { // m s 
		
		// * { } 마다 입력객체 
		Scanner scanner = new Scanner(System.in);
	
		// 문제1 : 
		/*
		System.out.println("	"
				+ "|\\_/|\r\n"
				+ "	|q p|   /}\r\n"
				+ "	( 0 )\"\"\"\\\r\n"
				+ "	|\"^\"`    |\r\n"
				+ "	||_/=\\\\__|");
		*/
		
		// 문제2 : 
		/*
		// [ 입력 -> 저장 ] 
		System.out.print("작성자 : "); 	String 작성자 = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : ");		String 내용 = scanner.nextLine();
		System.out.print("날짜 : ");		String 날짜 = scanner.next();
		
		// [ 출력 ] 
		System.out.printf("---------------------- 방문록 ---------------------\n");
		System.out.printf("%3s | %6s | %15s | %6s \n" , "번호" , "작성자" , "내용" , "날짜");
		System.out.printf("%4d | %6s | %15s | %6s \n" , 1 , 작성자 , 내용 , 날짜 );
		System.out.printf("--------------------------------------------------");
		*/
		
		// 문제 3 
		// [ 입력 -> 저장 ] 
		/*
		System.out.print("기본급 : "); 	int 기본급 = scanner.nextInt();
		System.out.print("수당 : "); 		int 수당 = scanner.nextInt();
		// [ 계산 ] 
		int 실수령액 = 기본급 + 수당 - (int)( 기본급*0.1 );	// 1:100% 0.1 : 10%
		// int 	=   int + int - (강제타입변환)( int * double )
			// 0.1 -> 자동으로 double 
			// int * double => 피연산자중 더 큰 허용범위 결과 -> double
			// 강제타입 변환 (int)double
		// [ 결과 ] 
		System.out.println("실수령액 : " + 실수령액 );
		*/
		
		// 문제4
		// [ 입력 -> 저장 ]
		System.out.print("금액 : "); 		int 금액 = scanner.nextInt();
		// [ 출력 = 십만원권 ]
		System.out.println("- 십만원 : " +( 금액/100000 )+"장");
		// [ 출력 = 만원권 ] 
		금액 -= (금액/100000) * 100000; // 1. 원금[금액] 에서 십만원권 제외
		System.out.println("- 만원 : " + ( 금액/10000 ) + "장");
		// [ 출력 = 천원 ]
		금액 -= (금액/10000) * 10000 ; // 1. 원금[금액] 에서 만원 제외
		System.out.println("- 천원 : " + ( 금액/1000 ) + "장");
		// [ 출력 = 백원 ]
		금액 -= (금액/1000) * 1000;
		System.out.println("- 백원 : " + ( 금액/100 ) + "개");
		
	} // m e 
} // c e 



















