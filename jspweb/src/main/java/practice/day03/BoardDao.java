package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() { 	return dao; }

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
		}catch (Exception e) {System.out.println(e);}
	}
	
	// 1. 등록 [ 인수 : 입력받은 값  / 반환 : 성공여부 ] 
	public boolean onwrite( BoardDto dto ) {
		String sql ="insert into ex3( bcontent , bwriter) values( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getBcontent()  );
			ps.setString( 2 , dto.getBwriter() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 
	
	// 3. 
	
	// 4. 
	
	
	

}







