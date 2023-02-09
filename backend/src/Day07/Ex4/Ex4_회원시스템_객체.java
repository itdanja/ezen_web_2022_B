package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_객체 { // class s

	public static void main(String[] args) { // main s 
		Scanner scanner = new Scanner(System.in); // * 입력객체 
		
		Member[] memberList = new Member[3]; // Member객체 3개를 저장할수 있는 배열 선언 
											// Member객체 String 2개 저장할수 있는 클래스 
		while( true ) { // while s 
			// * 출력
			System.out.println("번호\t회원명\t전화번호");
			for( int i = 0 ; i<memberList.length ; i++ ) {
				if( memberList[i] != null ) {
					System.out.println( i+"\t"+
								memberList[i].name+"\t"+
								memberList[i].phone );
				}
			}
			System.out.print(" 1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { 
				System.out.print("회원명 : ");	String inputname = scanner.next();
				System.out.print("전화번호 : ");	String inputphone = scanner.next();
				
				for( int i = 0 ; i<memberList.length ; i++ ) {
					if( memberList[i] == null ) {
						// [ x ] String str = name +","+phone;
						// [ o ] 객체 만들기 
						Member member = new Member(); // 1. 객체 생성
						member.name = inputname;		// 2. 객체에 입력받은 값을 해당 필드에 대입 
						member.phone = inputphone;		// 3. 객체에 입력받은 값을 해당 필드에 대입 
						memberList[i] = member;			// 4. 객체를 배열에 저장 
						System.out.println(i+"번 회원이 등록 되었습니다. 정보 : " + memberList[i] );
						break;
					}
				}
				
			}
			else if( ch == 2 ) {
				System.out.print(" 삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				// 3. 배열내 데이터 삭제 // splice 기능 [ 배열내 null 만들기 ]
				memberList[ no ] = null;
				// * 삭제후 빈자리 채우기 [ 삭제된 인덱스 뒤로 한칸씩 당기기 ]
				for( int i = no ; i<memberList.length ; i++ ) {
					if( i+1 == memberList.length ) { // 마지막 인덱스 이면 
						memberList[i] = null; break;	// 마지막 인덱스 null 넣고 나가기 
					}
					memberList [ i ] = memberList[ i+1 ];
					if( memberList[i+1] == null ) break; // 다음 인덱스가 null 이면 종료 
				}
			}
			else { }
		} // while e 
	} // main e 
} // class e 
