
package Day02; // 현재 클래스가 존재하는 패키지 

// ! : 자바는 무조건 class 단위
	// 자바를 100% 객체지향
	// 클래스 기반으로 메모리 할당 : 객체
	// 클래스 : 객체 설계도
public class Ex1_출력 { // class s 
	
	// * main함수 : main 스레드 [ 스레드 : 작업 수행 주체 ]
	public static void main(String[] args) {
		// 1.[ p.67 ] syso+자동완성
		System.out.println();
			// System : 시스템 클래스 [ 관련 메소드 제공 ]
				// out : 출력  vs  in : 입력 
					// println() : 출력후 줄바꿈처리  [ js : console.log() ] 
					// print() : 출력
					// printf() : 형식 출력 
		// 2. print()
		System.out.print("print 함수1 ");
		System.out.print("print 함수2 ");
		
		// 3. println()
		System.out.println("println 함수1"); // 출력후 \n
		System.out.println("println 함수1");	// 출력후 \n
		
		// 4. [p.69] printf( "형식문자열" , 값 )
			/*
			 * 형식문자열 
			 * 		%d : 정수
			 * 			%자릿수d		오른쪽 자릿수 차지 [ 만일 자릿수에 데이터 없으면  공백 채우기 ]
			 * 			%-자릿수d		왼쪽부터 자릿수 차지
			 * 			%0자릿수d		왼쪽부터 자릿수 차지[ 만일 자릿수에 데이터 없으면  0 채우기 ]
			 * 		%f : 실수 
			 * 			%자릿수.소수자릿수f
			 * 		%s : 문자열
			 */
		int value = 123; /* int자료형에 'value'이름 으로 123 저장  */
		System.out.println("상품의 가격 : " + value + "원" );	// 123원
		System.out.printf("상품의 가격 : %d원\n" , value );	// 123원
		System.out.printf("상품의 가격 : %6d원\n" , value );	//    123원
		System.out.printf("상품의 가격 : %-6d원\n" , value );	// 123   원 
		System.out.printf("상품의 가격 : %06d원\n" , value );	// 000123원 
		
		double area = 3.14159; 
		System.out.println("파이 출력 : " + area);	// 3.14159
		System.out.printf("파이 출력 : %f \n" , area );	// 3.14159
		System.out.printf("파이 출력 : %.1f \n" , area );	// 3.1
		System.out.printf("파이 출력 : %3.2f \n" , area );	// 3.14
		System.out.printf("파이 출력 : %3.3f \n" , area );	// 3.142
		System.out.printf("파이 출력 : %3.4f \n" , area );	// 3.1416
		System.out.printf("파이 출력 : %3.5f \n" , area );	// 3.14159
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n" , 1 , name , job);
						//      1 | 홍길동        |         도적 
	}
}// class e

/*
 	String 	: 문자열 클래스 
 	System	: 시스템 클래스
 	
 	제어 / 이스케이프 문자 
 		\n  : 줄바꿈
 		\t	: 들여쓰기
 		\"	: " 출력 
 		\'	: ' 출력 
 */


















