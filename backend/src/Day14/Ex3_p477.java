package Day14;

public class Ex3_p477 { // class s 

	
	// 1.
	public static void findClass() throws Exception {
		
		Class.forName("java.lang.String2"); // 일반예외
		
	}
	
	public static void main(String[] args) throws Exception {
		try {
		findClass();}
		catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(" 확인 ");
		
	}
	
	
} // class e

/*
	예외 떠넘기기
		- 메소드 내부에서 예외발생했을때 메소드 호출했던 곳으로 예외를 넘기기
		- throws
		- 메소드 마다 예외처리를 하면 코드가 많아진다. -> 이동후 한곳에서 처리 
*/



