package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {

	// * 싱글톤 : Dao 싱글톤 사용하는 이유 : 프로그램내 DB 연동 1번만 해서 하나의 연동 객체 사용 
		// 1. 내부에 객체 만들기 
	private static BoardDao dao = new BoardDao();
		// 2. 생성자는 private -> 외부에서 new 사용금지 
		// 3. 외부에서 내부객체 사용할수 있게 내부객체 반환 메소드 [ getInstance ]
	public static BoardDao getInstance() { return dao;}
	
	// 1. 필드
	private Connection conn;		// 1. 연결된 DB구현객체를 가지고있는 인터페이스  
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [ +매개변수 가능 ] 인터페이스
	private ResultSet rs;			// 3. 실행된 SQL 결과 인터페이스
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동될수 있게 할려고  ]
	private BoardDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15" , "root" ,"1234");
		}catch (Exception e) { System.out.println(e.getMessage() );}
	}
	
	// 3. SQL 처리 메소드 
	// 1. 회원가입 메소드 [ 인수 : ? , 반환 : ? ]
	public  signup( ) {
		
	}
	
}


