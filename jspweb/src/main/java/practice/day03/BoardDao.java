package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	
	/*
	 
	 drop table ex3;
	create table ex3(
		bno 	int 			auto_increment		primary key ,
	    bcontent	varchar(1000)	,
	    bwriter	varchar(100)	,
	    bdate 	datetime		default now()
	);
	select * from ex3;

	  
	 */
	
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
	// 2. 모든 방문록 출력 [ 인수 : x / 반환 : 여러개[list] 의 dto ]
	public ArrayList<BoardDto> onlist(){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql ="select * from ex3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 레코드1개 = if / 레코드여러개 = while 
				BoardDto dto = new BoardDto( 
						rs.getInt( 1 ), rs.getString(2), 
						rs.getString(3), rs.getString(4) );
				list.add(dto);
			} // while end 
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	// 3. 삭제 
	public boolean ondelete( int bno ) {
		String sql = "delete from ex3 where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , bno);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 수정 
	public boolean onupdate( int bno , String newContent ) {
		String sql ="update ex3 set bcontent = ? where bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , newContent );
			ps.setInt( 2 , bno );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	

}


























