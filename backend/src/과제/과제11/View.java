package 과제.과제11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	private static View view = new View();
	private View() {}
	public static View getInstance() { 
		return view; 
	}
	private Scanner scanner = new Scanner(System.in);
	public void index() {
		while(true) {
			try {
				System.out.print("1.등록[C] 2.출력[R] 3.수정[U] 4.재고수정[U] 5.삭제[D] : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) { regist(); }
				else if( ch == 2 ) {}
				else if( ch == 3 ) {}
				else if( ch == 4 ) {}
				else if( ch == 5 ) {}
			}catch ( InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in); // 입력값 초기화 
			}catch( Exception e ) {
				System.out.println("프로그램내 오류 발생 : 관리자에게 문의");
			}
		}
	} // index end 
	
	public void regist() {
		System.out.println(" >>>> 제품 등록 페이지 >>>> ");
		System.out.print(">제품명 : ");	String pname =scanner.next();
		System.out.print(">가격 : ");		int pprice = scanner.nextInt();
		System.out.print(">초기재고 : ");	int pstock = scanner.nextInt();	
		boolean result = 
		Controller.getInstance().regist(pname, pprice, pstock);// 1. 컨트롤에게 입력받은 값을 전달해서 결과를 저장 
		if( result ) { System.out.println("[[제품등록]]");}
		else { System.out.println("[[등록실패]]");}
	}
	
}







