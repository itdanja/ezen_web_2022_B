package Day09.Ex9;

/*
 
 	싱글톤 : 프로그램내 하나의 객체를 가지는 패턴
  		- 1. 클래스 내부에 객체 만들기
  		- 2. 생성자 private
  		- 3. 내부객체 반환해주는 함수 : getInstance()
 		- * 함수호출시 객체가 필요한데 외부에서 객체 금지 -> static
 */

public class Member {

	// 1. 자신의 타입으로 객체 생성 한다.
	private static Member mem = new Member();
	// 2. private
	// 3. 생성자도 private 
	private Member() {}
	// 4. 
	public static Member getInstance() {
		return mem;
	}
	// 5. static
	
	
	
}
