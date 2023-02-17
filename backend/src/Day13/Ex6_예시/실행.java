package Day13.Ex6_예시;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		키보드 key = null; // 변수 선언 [ 구현 안된.. 추상만 있는 상태 ]
		
		while(true) { // while 구현객체 선택 
			System.out.println("---- 바탕화면 ----");
			System.out.println("1.피파온라인 ");
			System.out.println("2.메이플스토리 ");
			System.out.print("선택 : ");
			int ch = scanner.nextInt();
			// 2. 입력한 번호의 구현한 클래스[객체]를 대입
			if( ch == 1 ) { key = new 피파온라인(); }
			else if( ch == 2 ) { 
				
				key = new 메이플스토리();
				
				System.out.println("1.마법사 2.전사 : ");
				int 입력2 = scanner.nextInt();
				if( 입력2 == 1 ) { key = new 마법사(); }
				if( 입력2 == 2 ) { key = new 전사(); }
				
			}
			// 3. 실제로 게임 시작
			while(true) { // while 게임 실행 
				System.out.println(" 게임시작 ~~~ ");
				String 입력 = scanner.next();
				if( 입력.equals("A") ) {
					key.A버튼();
				}else if( 입력.equals("B") ) {
					
					key.B버튼();
				}else if( 입력.equals("X") ) {
					break;
				}
			}
		} // while end 
	}
}
