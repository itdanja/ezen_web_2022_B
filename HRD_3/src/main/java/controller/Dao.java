package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	// 1. [참고] DB 연동 함수 
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe",
				"system", "1234");
		return con;
	}
	// 2. DB 조작 인터페이스 3개 
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	// 3. 생성자를 통한 객체 생성시 DB 연동
	public Dao() {
		try {
			con = getConnection();
		}catch (Exception e) {System.out.println(e);}
	}
	// 4. 기능 함수 작성 
	// 4-1 후보조회 
	public List<Dto> getList(){
		String sql = " select A.m_no , A.m_name , B.p_name , A.p_school ,"
				+ "	A.m_jumin , A.m_city , B.p_tel1, B.p_tel2, B.p_tel3 "
				+ " from tbl_member_202005 A natural join tbl_party_202005 B";
		List<Dto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql); rs = ps.executeQuery();
			while( rs.next() ) {
				Dto dto = new Dto(
						rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), 
						rs.getString(9));
				list.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	// 4-2 투표하기 
	public boolean vote( Dto dto ) {
		String sql ="insert into tbl_vote_202005 values (?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getV_jumin() );ps.setString( 2 , dto.getV_name() );
			ps.setString( 3 , dto.getM_no() );	ps.setString( 4 , dto.getV_time() );
			ps.setString( 5 , dto.getV_area() );ps.setString( 6 , dto.getV_confirm() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} 
		return false;
	}
}




























