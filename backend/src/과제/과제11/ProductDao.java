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
	
}



















