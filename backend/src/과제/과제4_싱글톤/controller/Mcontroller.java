package 과제.과제4_싱글톤.controller;

public class Mcontroller {
	
	//1. 회원가입 처리
	public int signup( String id , String pw , 
				String confirmpw ,String name , 
				String phone){
		return 0;
	}
	
	// 2. 로그인 처리 
	public int login( String id , String pw ){
		return -2;
	}
	// 3. 아이디찾기 처리
	public String  findId( String name , String phone ){
		return null;
	}
	// 4. 비밀번호찾기 처리 
	public String findPw( String id , String phone ){
		return null;
	}
	// 5. 로그아웃 
	public boolean logOut() {
		return true;
	}
	
	
}
/*
	1. 회원가입 처리 
		인수 : id,pw,confirmpw,name,phone	반환 : 0:성공 , 1:패스워드실패

	2. 로그인 처리 
		인수 : id,pw			반환 : i:회원번호 , -1:비밀번호틀림  , -2:아이디가없음

	3. 아이디찾기 처리 
		인수 : name , phone			반환 : 찾은아이디 , null 

	4. 비밀번호 찾기 처리 
		인수 : id , phone			반환 : 찾은비밀번호 , null 
		
	10.로그아웃 처리 
		인수 : x				반환 : true 성공 , false 실패 


*/