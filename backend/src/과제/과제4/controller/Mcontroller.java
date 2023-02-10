package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

// * 처리/제어 담당
public class Mcontroller {
	// * DB 대신할 [ 데이터 저장소 ]
	ArrayList<Member> memberDb = new ArrayList<>();
	
	// 1. 회원가입 로직 
	public int signup( String id , String pwd , String confirmpwd , String name , String phone ) {
		// 1. 유효성검사
		if( !pwd.equals(confirmpwd) ) { return 1; }	// 회원가입실패 1
		// 2. 객체 만들어서
		Member member = new Member(id, confirmpwd, name, phone);
		// 3. db처리[ 리스트 ]  
		memberDb.add(member);
		return 0; // 회원가입 성공 0
	}
	// 2. 로그인 로직
	
	// 3. 아이디 찾기 로직
	
	// 4. 비밀번호 찾기 로직 
	

}
