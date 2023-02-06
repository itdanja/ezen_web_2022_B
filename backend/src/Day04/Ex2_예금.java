package Day04;

import java.util.Scanner;

public class Ex2_예금 { // c s 
	public static void main(String[] args) { //ms
		
		// * import java.util.Scanner;
		Scanner scanner = new Scanner(System.in);
		// * 예금액 [ 누적 ] , 계좌번호 , 패스워드 
		int balance = 0; String account = "123-1234"; short password = 1234;
		
		while( true ) { // 무한루프 [ 종료조건 : 4 입력시 break; ] 
			System.out.println("--------------------");
			System.out.println("1.예금 2.출금 3.잔액 4.종료 : ");
			System.out.println("--------------------");
			System.out.print(">> 선택 : ");
			int ch = scanner.nextInt();
			// ---------------------- 예금 ------------------------- // 
			if( ch == 1 ) {
				System.out.print(" >>> 예금할 계좌번호 : ");
				String inaccount = scanner.next();
				if( account.equals( inaccount ) ) {	// 만약에 계좌번호와 입력받은 계좌번호와 같으면
					System.out.print(" >>> 예금할 금액 : ");
					balance += scanner.nextInt();
					System.out.println(" >>> 예금후 금액 : " + balance );
				}else {
					System.out.println(" >>> 없는 계좌번호 입니다. ");
				}
			}
			// ------------------------------------------------ // 
			// --------------------- 출금 ------------------------ // 
			else if( ch == 2 ) {
				System.out.print(" >>> 출금할 계좌번호 : ");
				String inaccount = scanner.next();
				if( account.equals(inaccount) ) { // if1 s 
					System.out.print( " >>> 계좌 비밀번호 : ");
					short inpassword = scanner.nextShort();
					if( password == inpassword ) { // if2 s  // 만약에 비밀번호와 입력받은 비밀번호와 같으며
						System.out.print(" >>> 출금할 금액 : ");
						
						int pay = scanner.nextInt();
						if( balance > pay ) { // if3 s // 만약에 입력받은 출금액보다 잔액이 더 크면
							balance -= pay;
							System.out.println(" >>> 출금후 금액 : " + balance );
						}else {
							System.out.println(" >>> 잔액부족 : " + balance );
						} // if3 e 
						
					}else {
						System.out.println(" >>> 해당 계좌의 비밀번호가 다릅니다. ");
					} // if2 e
					
				}else {
					System.out.println(" >>> 없는 계좌번호 입니다.");
				} // if1 e 
			}
			// ------------------------------------------------ // 
			else if( ch == 3 ) { System.out.println(" >>> 예금 잔액 : " + balance ); 	}
			else if( ch == 4 ) { System.out.println(">>> 종료"); break; }
			else { System.out.println(">>> 알수없는 번호입니다. [ 다시입력 ] "); }
		} // while end 
	} // me 
} // c e 



/*
 
 	1. if중첩
 	2. 
 		자료형[char] 		변수 == 변수	 
 						'안' == '안'
 						
 		클래스[String] : 	객체A.equals(객체B)
 						"안녕" == "안녕"  	[X]
 						"안녕".equals("안녕")	[O]
 */













