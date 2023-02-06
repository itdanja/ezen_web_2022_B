package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크_변수버전 { // class s 
	public static void main(String[] args) { // main s 
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		// * 가격 변수
		int 콜라가격 = 300; 	int 사이다가격 = 400; 	int 환타 = 500;
		// * 재고 변수 
		int 콜라재고 = 10;		int 사이다재고 = 8;	int 환타재고 = 15;
		// * 장바구니 변수 
		int 콜라바구니 = 0;	int 사이다바구니 = 0;	int 환타바구니 = 0;
		
		// * 프로그램 실행 반복
		while( true ) { // while s 
			System.out.println("-------------------------");
			System.out.print("1.콜라 2.사이다 3.환타 4.결제 >>>>  ");
			int 메뉴 = scanner.nextInt();
			// * 메뉴에 따른 제어 !!! 
			if( 메뉴 == 1 ) {}
			else if( 메뉴 == 2 ) {}
			else if( 메뉴 == 3 ) {}
			else if( 메뉴 == 4 ) {}
			else { System.err.println(" [알림] 알수 없는 번호 입니다. "); }
		} // while e 
	} // main e 
} // class e 














