package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	// 1. 문항지에 있는 db연동 함수 
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	// 2. sql 조작 인터페이스 
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 3. 생성자 [ 객체 생성시 db 연동 함수 호출 ] 
	public Dao() {
		try { con = getConnection(); System.out.println("연동성공");
		}catch (Exception e) { System.out.println("연동실패"+e); }
	}
	// 4. 함수 
	// 4-1 학생목록 호출 
	public List<Dto> getList(){
		List<Dto> list = new ArrayList<>();
		String sql ="select * from student_tbl_03";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Dto dto = new Dto(
						rs.getString(1) ,
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5));
				list.add(dto);
			}
		}catch (Exception e) { System.out.println("오류:"+e);}
		return list;
	}
	// 4-2 점수 등록 함수 
	public boolean add( Dto dto ) {
		String sql = "insert into exam_tbl_03 values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getSno()  );	ps.setInt( 2 , dto.getEkor()  );
			ps.setInt( 3 , dto.getEmath()  );	ps.setInt( 4 , dto.getEeng()  );	
			ps.setInt( 5 , dto.getEhist()  );	ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 4-3 점수 출력 함수 
	public List<Dto> getExamList(){
		List<Dto> list = new ArrayList<>();
		String sql = "select "
				+ "      substr( A.sno , 1 , 1 ) 학년 ,"
				+ "      substr( A.sno , 2 , 2 ) 반 ,"
				+ "      substr( A.sno , 4 , 2 ) 번호 ,"
				+ "      A.sname 이름 ,"
				+ "      B.ekor 국어 ,"
				+ "      B.emath 수학 ,"
				+ "      B.eeng 영어 ,"
				+ "      B.ehist 역사 ,"
				+ "      ( B.ekor + B.emath + B.eeng + B.ehist ) 합계 ,"
				+ "      ( B.ekor + B.emath + B.eeng + B.ehist )/4 평균 ,"
				+ "      RANK() OVER( ORDER BY ( NVL( B.ekor , 0 ) + NVL( B.emath , 0 ) + NVL( B.eeng , 0 ) +NVL( B.ehist , 0 )  ) DESC ) 순위"
				+ "   from "
				+ "      student_tbl_03 A "
				+ "         FULL OUTER JOIN "
				+ "      exam_tbl_03 B "
				+ "         ON A.sno = B.sno "
				+ "   order by ( NVL( B.ekor , 0 ) + NVL( B.emath , 0 ) + NVL( B.eeng , 0 ) +NVL( B.ehist , 0 ) ) desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Dto dto = new Dto(
						rs.getString(4) ,
						rs.getInt(5) ,rs.getInt(6) , rs.getInt(7) ,
						rs.getInt(8) , rs.getInt(9) ,
						rs.getDouble(10), rs.getInt(11),
						rs.getString(1) ,rs.getString(2), 
						rs.getString(3) );
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }	
		return list;
	}
	
	
	
	
	
	
	
}













