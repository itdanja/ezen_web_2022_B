package Day09.Ex9_싱글톤;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 생성자가 private 이라서 객체 생성 불가능 
		// 2. 객체 없이 메소드[ static ] 호출
		Member m1 = Member.getInstance();
		Member m2 = Member.getInstance();
		
		System.out.println( m1 );
		System.out.println( m2 );
		
	}

}
