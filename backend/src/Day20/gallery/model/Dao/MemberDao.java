package Day20.gallery.model.Dao;

import Day20.gallery.model.Dto.MemberDto;

public class MemberDao extends Dao {
	// 1. 싱글톤 [ 내부에 본인객체 만든다. ]
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao;}
	
	// 기능 메소드 
	// 1. 아이디 중복체크 [ 아이디 검색 ]
	public boolean idCheck( String mid ) {
		String sql = "select * from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			// 검색된 레코드가 있으면 [ 중복된 아이디  ]
			if( rs.next() ) { return true; } 
			// 없으면 [ 중복된 아이디가 아니다 ] 
			else { return false; }
		}
		catch (Exception e) {System.out.println(e);}
		return true; // 그외 
	}
	// 2. 회원가입 
	public int signup( MemberDto dto ) {
		String sql ="insert into member( mid , mpw , mname , mphone )"
				+ " values(  ? , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMid() );		// 첫번째 ? 에 값 대입 
			ps.setString( 2 , dto.getMpw() );		// 두번째 ? 에 값 대입 
			ps.setString( 3 , dto.getMname() );		// 세번째 ? 에 값 대입 
			ps.setString( 4 , dto.getMphone() );	// 네번째 ? 에 값 대입 
			ps.executeUpdate();
			return 1; // 성공 
		}catch (Exception e) {System.out.println(e);}
		return 3; // db오류 
	}
	
	
}













