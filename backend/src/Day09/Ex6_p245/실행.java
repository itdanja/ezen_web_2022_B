package Day09.Ex6_p245;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 인스턴스멤버 호출
			// 객체 -> 인스턴스멤버 호출
		Calculator mycal = new Calculator();
		System.out.println( mycal.no );
		mycal.no = 10;
		System.out.println( mycal.getNo() );
		
		// 2. 정적멤버 호출 
		System.out.println( Calculator.pi );
		double result1 = 10*10*Calculator.pi;
		
		Calculator.plus( 10 , 5);
		Calculator.minus( 10 , 5 );
		
		System.out.println( Calculator.info );
	}
}
