package Day08.Ex2_p220;

public class 실행 {
	public static void main(String[] args) {

		// 1. 객체 생성 [ 빈생성자 ]
		Korean k1 = new Korean();
			// 1. 객체 정보[ 객체명.toString() ] 출력 
		System.out.println( k1.toString() );
			// 2. 객체 필드 호출 [ 객체명.필드명 ] 
		System.out.println( k1.nation );
		System.out.println( k1.name );
		System.out.println( k1.ssn );
		
		// 2. 객체 생성 
		Korean k2 = new Korean("박자바", "011225-1234567");
		System.out.println( k2.toString() );
		
		System.out.println( k2.nation );
		System.out.println( k2.name );
		System.out.println( k2.ssn );
			
	}
}
