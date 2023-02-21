package Day15.Ex4_p512;

public class System클래스 {
	public static void main(String[] args) {
		
		
		System.out.println("출력");	// 콘솔에 출력 
		System.err.println("에러");	// 콘솔에 에러[빨강] 출력
		
		int value = 100;	// int에 100 대입 가능 [ 정수니까 가능 ]
		// int value2 = "100";	// int에 "100" 대입 불가능 [ 문자니까 불가능 ]
			// 문자열 --> 기본타입 변환
		int value3 = Integer.parseInt("100"); // "100" -> 100 변환
		
		// 1. 
		try { // try{} 에 예외[오류] 가 발생할것 같은 코드[*경험]
			int value4 = Integer.parseInt("1xx");	// "1xx" -> 변환x
		}
		catch (Exception e) { // try{} 에서 예외[오류] 발생했을때 catch{ } 실행
			System.err.println("에러 내용");
			System.err.println( e.getMessage() );
		}
		
		
		// 2. p.514
		
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			if( keyCode != 13 && keyCode != 10 ) { // 엔터[ 13,10 ]가 아니고 
				if( keyCode == 49 ) { // 숫자1의 코드는 49
					speed++;
				}else if (keyCode == 50) { // 숫자2의 코드는 50
					speed--;
				}else if( keyCode == 51 ) { // 숫자3의 코드는 51
					//break;
					System.exit(0) ;  // 0:정상종료 , 1 or -1 : 비정상종료   으로 관례적으로 뜻함
				}
				System.out.println("현재 속도 : " + speed );
				System.out.println("1.증속 2.감속 3.중지 : ");
			}
			
			try {
				keyCode = System.in.read();	// 입력받아 코드로 반환 [*예외처리 필수 ]
			}catch (Exception e) {
				
			}
		} // while end 
		
		
	}
}












