package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Mcontroller;

public class Front {
	
	//*싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지 
	public void index() { 
		while(true) { // 무한루프 // 종료조건 : 없음 
			System.out.println("--------- 이젠 커뮤니티 --------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup_page(); }	// 각 번호별 함수 호출 
			else if( ch == 2 ) { login_page(); }
			else if( ch == 3 ) { findid_page(); }
			else if( ch == 4 ) { findpw_page(); }
		} // while end 
	}// end 
	
	// 2. 회원가입 페이지 
	public void signup_page() {
		
		// 1. 입력부 
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pw = scanner.next();
		System.out.println("비밀번호 확인 : ");	String confirmpw = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기 
		int result = Mcontroller.getInstance().signup( id, pw, confirmpw, name, phone);
		// 3. 결과 제어 
		if( result == 1 ) { System.out.println("[알림]회원가입 실패. 패스워드가 서로 다릅니다. ");}
		else if( result == 0 ) { System.out.println("[알림]회원가입 성공. 감사합니다. ");}
	} // end 
	
	// 3. 로그인페이지 
	public void login_page() {
		// 1. 입력부
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");	String pw = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().login(id, pw);
		
		if( result == -1 ) { System.out.println("[알림] 로그인 실패 . 패스워드 틀림 ");}
		else if( result == -2 ) { System.out.println("[알림] 로그인 실패 . 존재하는 아이디 없습니다. ");}
		else { System.out.println("[알림] 로그인 성공 . 안녕하세요 "); board_page(); }
		// * 로그인 성공시 게시물을 볼수 있도록 board_page() 함수로 이동[호출]
	} // end 
	// 4. 아이디찾기 페이지 
	public void findid_page() {
		// 1. 입력부 
		System.out.print("이름 : ");		String name = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기 
		String result = Mcontroller.getInstance().findId(name, phone);
		if( result == null ) { System.out.println("[알림] 아이디 찾기 실패 ");}
		else { System.out.println("[알림] 회원님의 아이디 : " + result + " 입니다. ");}
	} // end 
	// 5. 비밀번호 찾기 페이지 
	public void findpw_page() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String result = Mcontroller.getInstance().findPw(id, phone);
		if( result == null ) { System.out.println("[알림] 비밀번호 찾기 실패 ");}
		else { System.out.println("[알림] 회원님의 비밀번호 : " + result + " 입니다. ");}
	} // end 
	
	// 6. 로그인성공시 게시물 출력 페이지 
	public void board_page() {}
	// 7. 게시물 쓰기 페이지 
	public void write_page() {}
	// 8. 게시물 상세 페이지 
	public void view_page() {}
	// 9. 게시물 수정 페이지 
	public void update_page() {}
}
