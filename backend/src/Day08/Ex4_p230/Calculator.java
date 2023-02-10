package Day08.Ex4_p230;

public class Calculator {
	// 1. 필드
	// 2. 생성자
	// 3. 메소드 
		// 1. 인수x 반환x 
	void powerOn() { 
		System.out.println("전원을 켭니다.");
	}
		// 2. 인수x 반환x 
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
		// 3. 인수 : x , y   / 반환 : int 	// 예 ) x=3 y=5		return = 8
	int plus( int x , int y ) {
		int result = x + y;
		return result;
	}
		// 4. 인수 : x , y  / 반환 : double // 예 ) x=3 y=5		return = 0.6
	double divide( int x , int y ) {
		double result = (double)x / (double)y;
		return result;
	}
		// 5. 인수 : x , y / 반환 x
	void multiply( int x , int y ) {
		double result = (double)x * (double)y;
		System.out.println( result );
	}
		// 6. 인수x / 반환 o
	String info( ) {
		return "이젠 계산기";
	}
		// 7. 내부에서 함수호출 
	void 함수호출() {
		powerOn(); // 내부에서 함수 호출시 : 함수명();
	}
	
}
/*
 
 	함수 = 메소드 
 	
 	js 선언부								java 선언부
 	function 함수명( 인수1, 인수2 ) {			리턴타입 함수명( 인수1, 인수2 ) {
 	
 	}									}
 	
 	js 호출								java 내부 호출
 	함수명( 인수1 , 인수2 )					함수명( 인수1 , 인수2 )
  				
  										외부 호출 - 객체명 필요
  										객체명.함수명( 인수1 , 인수2 )
	
	1. 인수x 반환x
		void 함수명( ) { } 
	2. 인수o 반환x
		void 함수명( 인수1 , 인수2 ) { } 
	3. 인수x 반환o
		리턴타입 함수명( ) {  return 값; } 
	4. 인수o 반환o
		리턴타입 함수명( 인수1 , 인수2 ) { return 값; }
		 
  				
 */












