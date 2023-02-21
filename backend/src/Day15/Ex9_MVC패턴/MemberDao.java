package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {

	// * 싱글톤 : Dao 싱글톤 사용하는 이유 : 프로그램내 DB 연동 1번만 해서 하나의 연동 객체 사용 
		// 1. 내부에 객체 만들기 
	private static MemberDao dao = new MemberDao();
		// 2. 생성자는 private -> 외부에서 new 사용금지 
		// 3. 외부에서 내부객체 사용할수 있게 내부객체 반환 메소드 [ getInstance ]
	public static MemberDao getInstance() { return dao;}
	
	// 1. 필드
	private Connection conn;		// 1. 연결된 DB구현객체를 가지고있는 인터페이스  
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [ +매개변수 가능 ] 인터페이스
	private ResultSet rs;			// 3. 실행된 SQL 결과 인터페이스
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동될수 있게 할려고  ]
	private MemberDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15" , "root" ,"1234");
		}catch (Exception e) { System.out.println(e.getMessage() );}
	}
	
	// 3. SQL 처리 메소드 
	// 1. 회원가입 메소드 [ 인수 : Dto( id,pw ) , 반환 : 성공[true],실패[false] ]
	public boolean signup( MemberDto dto ) {
		// 1. SQL 작성한다.
		String sql = "insert into member ( mid , mpw ) values ( ? , ? )";
		// 2. 연동 DB에 SQL 대입한다. [ ps -> 매개변수 조작 가능 ]
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능 
			ps.setString( 1 , dto.getMid() );// SQL 구문내 첫번째 ? 에 대한 데이터 대입 
			ps.setString( 2 , dto.getMpw() ); // SQL 구문내 두번째 ? 에 대한 데이터 대입
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환
			return true; // 여기까지 문제 없었으면 저장 성공 
			
		}catch (Exception e) { System.out.println("DB 오류 : " + e); }
		return false; // try{} 문제가 있으면 실행되는 구역 -> 저장 실패
	}
	//////////////////// ------------------------------------- ////////////////////////////////
	
	// 2. 모든 회원 출력 [ 인수 : x 		반환 : 여러명[ ArrayList vs 배열 ] 회원정보[Member] ]
	public ArrayList<MemberDto> list() { return null ; }
	
}


















