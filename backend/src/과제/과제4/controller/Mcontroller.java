package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

// * 처리/제어 담당
public class Mcontroller {
	// * DB 대신할 리스트 [ 데이터 저장소 ]
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
	public int login( String id , String pwd ) {
		
		// * 모든 멤버들중 동일한 아이디/비밀번호 찾기 
		for( int i = 0 ; i<memberDb.size() ; i++ ) {
			// 1.만약에 i번째 회원의 아이디와 입력받은 아이디와 같으면
			if( memberDb.get(i).id.equals( id ) ) {
				
				// 2. 만약에 i번째 회원의 비밀번호와 입력받은 비밀번호가 같으면
				if( memberDb.get(i).pwd.equals(pwd) ) {
					return i; // 회원 번호[인덱스] 반환 
				}else {
					return -1; // 비밀번호가 틀림
				}
				
			} // if end 
		} // for end 
		return -2; // for문 다 방문했지만 동일한 아이디 없었다.
	}
	// 3. 아이디 찾기 로직  // [ 인수 : 이름[String],전화번호[String]  , 반환 : 찾은아이디[String] ]
	public String findId( String name , String phone ) {
		// 입력받은 이름과 전화번호와 일치한 회원찾기
		// 향상된 for( 타입 반복변수명 : 리스트/배열 ) { }
		for( Member m : memberDb ) {
			if( m.name.equals(name) && m.phone.equals(phone) ) {
				return m.id; // 찾은 아이디를 리턴 
			}
		}
		return null; // 아이디 못찾았다.-> null 리턴 
	}
	
	// 4. 비밀번호 찾기 로직 
	

}









































