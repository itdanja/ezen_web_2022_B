package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/과제11","root","1234");
		}catch (Exception e) { System.out.println( e ); }
	}
	public static ProductDao getInstance() { return dao; }
	
	// 1. 제품등록 [ 인수 : Dto(이름,가격,초기재고) / 반환 : true,false ]
	public boolean regist( ProductDto dto ) {
		String sql ="insert into product ( pname , pprice , pstock ) values( ? , ? , ? ); "; //1.SQL작성
		try {
			ps = conn.prepareStatement(sql); //2.연동DB에 SQL 대입
			ps.setString( 1 , dto.getPname() ); //3.SQL 조작 [ ? 매개변수에 데이터 대입 ]
			ps.setInt( 2 , dto.getPprice() );	//  ps.set타입명( ?순서번호 , 데이터 )
			ps.setInt( 3 , dto.getPstock() );
			ps.executeUpdate(); //4.SQL 실행
			return true; //5.SQL 결과
		}catch (Exception e) {System.out.println(e);}
			return false;
	}
	// 2. 모든 제품 출력 [ 인수:x / 반환 : 여러개[ArrayList]제품[dto]
	public ArrayList<ProductDto> getProductAll( ){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // SQL 결과를 rs 인터페이스로 반환
			while( rs.next() ) { // 결과에서 레코드 하나씩 반복  rs.next() : 다음 레코드 
				// 레코드 1개 --> 객체1개 [ 필드 호출 rs.get타입(필드순서번호) ] 
				ProductDto dto = new ProductDto( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4) );
				list.add(dto); // 객체1개 --> 리스트		
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 제품 수정 [ 이름 , 가격 ] 인수 : 제품번호[누구의] , 새로운이름 , 새로운가격 / 반환 : true or false
	public boolean update( int pno , String pname , int pprice  ) {
		String sql ="update product set pname = ? , pprice = ? where pno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , pname );
			ps.setInt( 2 , pprice );
			ps.setInt( 3 , pno );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 재고 수정 [ 인수 : 제품번호[누구의] , 새로운재고 / 반환 : true or false ]  
	public boolean stockUpdate( int pno , int pstock) {
		String sql = "update product set pstock = ? where pno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , pstock );
			ps.setInt( 2 , pno );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 5. 제품 삭제 [ 인수 : 제품번호[누구의] / 반환 : true or false ]
	public boolean delete( int pno ) {
		String sql = "delete from product where pno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
}






















