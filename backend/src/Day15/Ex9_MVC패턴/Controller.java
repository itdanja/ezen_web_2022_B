package Day15.Ex9_MVC패턴;

import java.util.ArrayList;

public class Controller {
	// 싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInController() { return con; }
	
	public boolean signup( String mid , String mpw ) {
		// 1.유효성검사 [ 생략 ] 
		// 2.객체화[ 이유 : 여러개 변수가 이동하면 로직이 길어짐 -> 여러개 변수를 하나의 객체로 ]
		MemberDto dto = new MemberDto( 0 , mid, mpw);
		// 3. 해당 객체를 DB에 저장 [ DAO 호출 ] 하고 실행 결과 저장 
		boolean result = MemberDao.getInstance().signup(dto);
		// 4. 실행 결과 반환 
		return result;
	}
	
	public ArrayList<MemberDto> list() { return null; }
	
}



