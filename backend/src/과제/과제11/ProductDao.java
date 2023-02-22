package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	// 2. 
}



















