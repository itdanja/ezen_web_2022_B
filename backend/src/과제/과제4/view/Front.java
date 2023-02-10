package 과제.과제4.view;
// * 입출력 : print, scanner
import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

public class Front {
	
	Scanner scanner = new Scanner(System.in); // * 입력객체 
	Mcontroller mc = new Mcontroller();

	// 1. 메인페이지 
	public void index() {
		while(true) {
			System.out.println("━━━━━━━━━━━━━━⊱༻ 이젠 커뮤니티 ༺⊰━━━━━━━━━━━━━━");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { login(); }
			else if( ch == 3 ) { findId(); }
			else if( ch == 4 ) { findPassword(); }
			else { } 
		}
	}
	
	// 2. 회원가입 페이지
	void signup() {
		System.out.print("아이디 : ");		String id= scanner.next();
		System.out.print("비밀번호 : ");		String pwd=scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpwd=scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		
		int result = mc.signup( id , pwd , confirmpwd , name , phone );
		
		if( result == 1 ) {
			System.out.println("[회원가입 실패]");
		}else if( result == 0 ) {
			System.out.println("[회원가입 성공]");
		}
	}
	
	// 3. 로그인 페이지
	void login() {
		System.out.print("아이디:");	String id = scanner.next();
		System.out.print("비밀번호:");	String pwd = scanner.next();
		
		int result = mc.login(id, pwd);
		if( result >= 0 ) { // 0~숫자 -> 로그인 성공한 회원의 번호
			System.out.println("[알림] 로그인 성공 ");
			// 게시판으로 이동
		}else if( result == -1 ) {	// -1 : 비밀번호 틀림 
			System.out.println("[알림] 비밀번호가 다릅니다.");
		}else if( result == -2 ) {	// -2 : 아이디 없다.
			System.out.println("[알림] 없는 회원 입니다.");
		}
	}
	
	// 4. 아이디 찾기 페이지
	void findId() {
		System.out.print("이름 : "); 		String name = scanner.next();	// 출력->입력->변수저장
		System.out.print("전화번호 : ");	String phone =scanner.next();
		String result = mc.findId(name, phone);	// 함수 호출하는데 이름과 전화번호 전달 하고 함수 결과를 result 변수에 저장 
		if( result == null ) { // 만약에 찾은 아이디가 없으면 
			System.out.println("[알림] 일치하는 회원정보가 없습니다.");
		}else { // 만약에 찾은 아이디가 있으면
			System.out.println("[알림] 회원님의 아이디 : " + result );
		}
	} // 
	
	// 5. 비밀번호 찾기 페이지 
	void findPassword() {}
}




























