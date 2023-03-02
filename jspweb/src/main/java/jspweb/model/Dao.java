package jspweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	/*
			create database jspweb;
			use jspweb;
			create table ex1(
				e_data varchar(100) 
			);
	 */
	// 1. 내부객체 와 내부객체 반환 메소드 
	private static Dao dao = new Dao();		public static Dao getInstance( ) { return dao; }
	
	Connection con ;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기 
			Class.forName("com.mysql.cj.jdbc.Driver"); // console프로젝트 X --> 웹서버 프로젝트 O
			con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/jspweb",
						"root",
						"1234"
					);
			System.out.println("연동성공");
		}catch (Exception e) {System.out.println("연동실패:"+e);	}
	}
	
	// 2. SQL 메소드 
	public boolean setData( String data ) {
		// 1. SQL 작성
		String sql = "insert into ex1 values(?)";
		try {
			ps = con.prepareStatement(sql);// 2. 연결된 JDBC에 SQL 대입
			ps.setString( 1 , data );	// 3. SQL 조작 
			ps.executeUpdate();			// 4. SQL 실행 --> 5. SQL 결과[rs]
			return true;				// 6. 응답 
		}catch (Exception e) {System.err.println(e);}
		return false;
	}

}

















