package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 { // class s
	public static void main(String[] args) { // main s
		Scanner scanner = new Scanner(System.in); // 입력객체
		// * 문자열[String] 3개를 저장할수 있는 배열 선언
		// memberList = { null , null , null }
		String[ ] memberList = new String[3]; // 고정길이 
		while(true) { // 무한루프 [ 종료조건 : 없음 ]
			// 2. 배열내 데이터 출력 
			System.out.println("번호\t회원명\t전화번호");
			for( int i = 0 ; i<memberList.length ; i++ ) {
				if( memberList[i] != null) { // null 데이터없다 -> split 불가능 
					String[] member = memberList[i].split(","); // "유재석 , 010-4444-4444" -> split(",")
					// member = { "유재석" , "010-4444-4444" }
					System.out.println( i +"\t"+member[0] + "\t" + member[1] );
				}
			}
			System.out.print(" 1.회원등록 2.회원삭제 : "); // 출력
			int ch = scanner.nextInt();// 입력받은 값 저장 변수 
			if( ch == 1) { // 1. 1입력했을때
				// * 출력 -> 입력 -> 저장 
				System.out.print("회원명 : ");	String name = scanner.next();
				System.out.print("전화번호 : ");	String phone = scanner.next();
				// 1. 배열내 데이터 등록 // push 기능 만들기 [ 배열내 빈공간[null] 찾기 ]
				for( int i = 0 ; i<memberList.length ; i++ ) {
					if( memberList[i] == null ) { // 만약에 i번째 인덱스가 null 이면 
						memberList[i] = name+","+phone; // 이름과 전화번호 1개의 문자열 합치기 
						System.out.println(i+"번 회원이 등록 되었습니다. 정보 : " + memberList[i] );
						// memberList = { "유재석 , 010-4444-4444" , null , null } 
						break; // 저장했으면 반복문 종료 
					} // if end 
				} // for end 
				
			}// 1 if end 
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
				
			} //2. 2입력했을때
			else { }// 3. 그외
			
		} // while end 
		
	} // main e 
} // class e 









