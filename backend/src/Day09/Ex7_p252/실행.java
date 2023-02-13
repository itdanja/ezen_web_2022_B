package Day09.Ex7_p252;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 객체 생성 
		Korean k1 = new Korean("123456-1234567", "김자바");
		
		// 2. 객체 멤버 호출
		System.out.println( k1.nation );
		System.out.println( k1.ssn );
		System.out.println( k1.name );
		
		// 3. 객체 멤버 변경 
		// k1.nation ="미국";	// final 변경 불가 
		// k1.ssn ="880420-1234567";// final 변경 불가
		k1.name = "유재석";	// final 아니기때문에 가능 
		
		// 4. 상수 호출 
		System.out.println( Korean.EARTH_RADIUS );
		System.out.println( Korean.EARTH_SURFACE_AREA );
		
	}
}
