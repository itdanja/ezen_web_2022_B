package 과제.과제11;

import java.util.ArrayList;
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
				else if( ch == 2 ) { getProductAll(); }
				else if( ch == 3 ) { update(); }
				else if( ch == 4 ) { stockUpdate();}
				else if( ch == 5 ) { delete();}
			}catch ( InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in); // 입력값 초기화 
			}catch( Exception e ) {
				System.out.println("프로그램내 오류 발생 : 관리자에게 문의");
			}
		}
	} // index end 
	
	// 1. 
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
	// 2. 
	public void getProductAll() {
		System.out.printf("%3s \t %10s \t %10s \t %10s \n" , "번호" , "제품명" , "가격","재고");
		ArrayList<ProductDto> result = Controller.getInstance().getProductAll(); // 1. 컨트롤에게 모든 제품 요청해서 저장 
		for( ProductDto dto : result  ){ // 2. 반환된 리스트를 반복문
			System.out.printf("%3d \t %10s \t %10d \t %10d \n" , 
					dto.getPno() , dto.getPname() , dto.getPprice() , dto.getPstock() );
		}
	}
	// 3.
	public void update() {
		System.out.println("------ 제품 수정 ------ ");
		System.out.print(" >> 수정할 제품번호 : ");	int pno = scanner.nextInt();
		System.out.print(" >> 수정할 제품이름 : ");	String pname = scanner.next();
		System.out.print(" >> 수정할 제품가격 : ");	int pprice = scanner.nextInt();
		boolean result=  Controller.getInstance().update(pno, pname, pprice);
		if( result ) { System.out.println("[수정성공]") ;}
		else { System.out.println("[수정실패]");}
	}
	
	// 4.
	public void stockUpdate() {
		System.out.println("------ 재고 수정 ------ ");
		System.out.print("제품번호 : ");		int pno =scanner.nextInt();
		System.out.print("수정할 재고량 : "); 	int pstock = scanner.nextInt();
		
		boolean result = Controller.getInstance().stockUpdate(pno, pstock);
		if( result ) { System.out.println("[재고수정 완료]");} 
		else { System.out.println("[재고수정 실패]");}
	}
	// 5. 
	public void delete() {
		System.out.println("------ 제품 삭제 ------ ");
		System.out.print("제품번호 : ");		int pno = scanner.nextInt();
		
		boolean result = Controller.getInstance().delete(pno);
		if( result ) { System.out.println("[삭제 성공]");}
		else { System.out.println("[삭제 실패]");}
		
	}
	
	
	
}























