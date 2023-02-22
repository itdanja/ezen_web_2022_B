package Day15.Ex9_MVC패턴;

import java.util.Scanner;

public class View {
	
	// 싱글톤 
	private static View view = new View();
	private View() { }
	public static View getInstance() { return view; }
	
	// 필드 
	Scanner scanner = new Scanner(System.in);
	// 1. 메인화면 
	public  void index() {
		while(true) {
			System.out.print("1.등록[C] 2.출력[R] 3.수정[U] 4.삭제[D] :");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { list(); }
			else if( ch == 3 ) { }
			else if( ch == 4 ) { }
		}
	} // index end 
	
	// 2. 회원가입 화면 
	public void signup() {
		System.out.println("------ 등록[C] ------ ");
		// 1. 데이터 2개 입력받기 
		System.out.print(" 아이디 : ");	String mid = scanner.next();
		System.out.print(" 비밀번호 : ");	String mpw = scanner.next();
		// 2. 입력받은 데이터2개 를 컨트롤에게 전달 후 결과 얻기 
		boolean result = Controller.getInController().signup( mid , mpw );
		// 3. 결과에 따른 출력
		if( result) { 	System.out.println(" [ 회원가입 성공 ]");
		}else { System.out.println(" [ 회원가입 실패 ]"); }
	} // signyp end 
	// 3. 회원목록 화면 
	public void list() { 	}
	
}























