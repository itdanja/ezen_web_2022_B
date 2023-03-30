package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/xe","root","1234");
		return con;
	}
	public Dao() {
		try {
			con = getConnection();
		}catch (Exception e) {System.out.println(e);}
	}
	
	// 1. 마지막 회원번호+1 가져오기
	public int getcustno() {
		String sql ="select max(custno)+1 from member_tbl_02;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(1);
		}catch (Exception e) {} return 0;
	}
	// 2. 회원등록
	public boolean join( MemberDto dto ) {
		String sql ="insert into member_tbl_02"
				+ " (custname,phone,address,joindate,grade,city)"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getCustname()  );
			ps.setString( 2 , dto.getPhone()  );
			ps.setString( 3 , dto.getAddress()  );
			ps.setString( 4 , dto.getJoindate()  );
			ps.setString( 5 , dto.getGrade()  );
			ps.setInt( 6 , dto.getCity()  );
			ps.executeUpdate(); return true;
		}catch (Exception e) {} return false;
	}
	
	// 3. 모든 회원 목록 출력 
	public ArrayList<MemberDto> getmemberlist(){
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select custno , custname ,  phone , address ,  joindate , "
				+ " if( grade = 'A' , 'VIP' , if( grade = 'B' , '일반' , '직원' ) ) as g , "
				+ " city from member_tbl_02;";
		try {
			ps = con.prepareStatement(sql); rs = ps.executeQuery();
			while(rs.next() ) {
				list.add( new MemberDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		}catch (Exception e) {System.out.println(e);} return list;
	}
}

























