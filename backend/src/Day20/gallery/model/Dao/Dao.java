package Day20.gallery.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	// 1. JDBC 인터페이스 3개
	public Connection con;			// DB연동 인터페이스 
	public PreparedStatement ps;	// SQL 조작 인터페이스 
	public ResultSet rs;			// SQL 결과 조작 인터페이스 
	
	public Dao() {
		try {	// DB연동 
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/boardDb"
				, "root" 
				, "1234" );
		}catch (Exception e) {System.out.println(e);}
	}

}
