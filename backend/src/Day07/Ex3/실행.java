package Day07.Ex3;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // * 입력객체 
		
		// * 객체활용
		System.out.println("아이디:") ;	String id = scanner.next();
		System.out.println("비밀번호:"); 	String password = scanner.next();
		
		// 1. // 아이디와 비밀번호 ','로 구분해서 하나의 문자열 합치기 
		String[] 배열 = new String[3];	// *String 객체 3개를 저장할수 있는 배열 
		// String 문자열 1개 저장하는 클래스/객체 
		
		배열[0] = id +","+password;  // 배열 에 합친문자열 대입 
		
		System.out.println( 배열[0].split(",")[0] );
		
		// 2. 회원 클래스 만들어서 회원객체 만들자
		Member[] 배열2 = new Member[3];	// Member 객체 3개를 저장할수 있는 배열 
		// Member 문자열 2개[id,password] 저장할수 있는 클래스/객체
		
		Member m1 = new Member();
		m1.id = id;	// 입력받은 아이디를 객체내필드인 id에 대입 
		m1.password = password; // 입력받은 패스워드를 객체내필드인 password에 대입 
		배열2[0] = m1;	// 배열2 에 m1 객체 대입 
		
		System.out.println( 배열2[0].id );
		
		
	} // main e 
} // class e 
