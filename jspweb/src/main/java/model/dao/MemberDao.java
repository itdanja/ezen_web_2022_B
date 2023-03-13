package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao; }
	
	
	// 1. 회원가입 
	public boolean signtp( MemberDto dto ) {
		String sql = "insert into member(mid,mpwd,memail,mimg)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMid() );
			ps.setString( 2 , dto.getMpwd() );
			ps.setString( 3 , dto.getMemail() );
			ps.setString( 4 , dto.getMimg() );
			ps.executeUpdate(); return true; 
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 모든 회원 호출 [ 관리자기준  인수:x 반환:모든회원들의 dto ]
	public ArrayList<MemberDto> getMemberList( ){
		ArrayList<MemberDto> list = new ArrayList<>(); // 모든 회원들의 리스트 선언 
		String sql = "select * from member";			// 1.SQL 명령어 작성 
		try {
			ps = con.prepareStatement(sql);				// 2. 연결된 con 에 SQL 대입해서 ps 
			rs = ps.executeQuery();						// 3. SQL 실행후 결과 RS 담고 
			while( rs.next() ) {						// 4. rs.next() : 다음레코드 [ t / f ]
				MemberDto dto = new MemberDto(			// 5. 레코드1개 --> dto 1개 생성 
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));	// 5-2 rs.get타입( 필드순서번호 )
				list.add(dto);							// 6. dto ---> 리스트 담기 
			}// w end 
		}catch (Exception e) {System.out.println(e);}
		return list;									// 7. 리스트 반환
	}
	
	// 3. 아이디 중복검사 
	public boolean idCheck( String mid ) {
												// 문자열 ' ' 필수 vs 정수/실수 ' ' 생략 
		// String sql = "select * from member where mid = '"+mid+"'";
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );	// ? 와일드 사용시
			rs = ps.executeQuery();
			// 만약에 검색 결과 레코드가 존재하면 중복 아이디 입니다. 
			if( rs.next() ) { return true; }
		}catch (Exception e) {System.out.println(e);}
		return false;  // 없으면 중복 아이디 아닙니다.
	}
	// 4. 아이디,비밀번호 검증   [ 로그인 ]
	public boolean login( String mid , String mpwd ) {
		String sql = "select * from member where mid = ? and mpwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , mpwd );
			rs = ps.executeQuery();
			if( rs.next() ) {  return true; } // 만약에 조건에 충족한 레코드가 존재하면 
		}catch (Exception e) {System.out.println(e);} return false;
	}
	// 5. 특정 회원1명 찾기 [ + 보유포인트 ]
	public MemberDto getMember( String mid ) {
		String sql = "select m.mno , m.mid , m.mimg , m.memail , sum( p.mpamount ) as  mpoint "
				+ "from member m , mpoint p "
				+ "where m.mno = p.mno and m.mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			if( rs.next() ) {
				// 결과 필드 : mno[1] , mid[2] , mimg[3] , memail[4] , mpoint[5]
				MemberDto dto = new MemberDto( 	rs.getInt(1), rs.getString(2), null, 
						rs.getString(3), rs.getString(4) );
				dto.setMpoint( rs.getInt(5) );
				return dto;	// 레코드1개 --> 회원1명 --> 회원dto 반환 
			}
		}catch (Exception e) {System.out.println(e);} 
		return null; // 없다.
	}
	// 6. 아이디찾기 
	public String findid( String memail ) {
		String sql = "select mid from member where memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , memail );
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getString( 1 ); } // 찾은 아이디 반환
		}catch (Exception e) {System.out.println(e);} 
		return "false"; // 없으면 false 
	}
	// 7. 비밀번호찾기 
	public String findpwd( String mid , String memail , String updatePwd ) {
		String sql = "select mno from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , memail);
			rs = ps.executeQuery();
			if( rs.next() ) {  // 만약에 동일한 아이디와 이메일 일치한 레코드가 있으면 [ 찾았다. ]
				sql = "update member set mpwd = ? where mno = ?";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , updatePwd );		// 임시비밀번호로 업데이트
				ps.setInt( 2 ,  rs.getInt( 1 ) );	// select 에서 찾은 레코드의 회원번호 
				int result = ps.executeUpdate();	// 업데이트한 레코드 개수 반환
				if( result == 1 ) { // 업데이트한 레코드가 1개 이면 
					// -- 이메일전송 테스트 되는경우 만 -- //
					//new MemberDto().sendEmail( memail, updatePwd ); // 임시비밀번호를 이메일로 보내기 
					//return "true";
					// -- 이메일전송 테스트 안되는 경우 -- //
					return updatePwd;
				}
			}
		}catch (Exception e) {System.out.println(e);} 
		return "false";
	}
}

















