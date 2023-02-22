package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance( ) { 
		return con; 
	} 
	
	// 1. 제품등록 서비스 
	public boolean regist( String pname , int pprice , int pstock ) {
		ProductDto dto = new ProductDto(0, pname, pprice, pstock); // 1. 변수3개 --> 객체1개 로 만들기
		boolean result = ProductDao.getInstance().regist(dto); //2.DB 요청 과 결과를 저장 
		return result; // 3.결과 리턴 
	}
	// 2. 
	public ArrayList<ProductDto> getProductAll(){ 
		return ProductDao.getInstance().getProductAll();
	}
	// 3. 
	public boolean update( int pno , String pname , int pprice ) {
		return ProductDao.getInstance().update(pno, pname, pprice);
	}
	// 4.
	public boolean stockUpdate( int pno , int pstock) {
		return ProductDao.getInstance().stockUpdate(pno, pstock);
	}
	// 5.
	public boolean delete( int pno ) {
		return ProductDao.getInstance().delete(pno);
	}
	
	
}








