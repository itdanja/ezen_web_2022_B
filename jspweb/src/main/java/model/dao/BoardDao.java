package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return dao; }
	
	// 1. 글쓰기 
	public boolean bwrite( BoardDto dto ) {
		String sql = "insert into board(btitle,bcontent,bfile,mno,cno) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getBtitle() ); 	ps.setString( 2 , dto.getBcontent() );
			ps.setString( 3 , dto.getBfile() );		ps.setInt( 4 , dto.getMno() );	
			ps.setInt( 5 , dto.getCno() );			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	// 2. 모든 글 출력
	public ArrayList< BoardDto > getBoardList( int startrow , int listsize ){
		ArrayList< BoardDto > list = new ArrayList<>();
		String sql = "select b.* , m.mid from member m natural join board b limit ? , ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , startrow ); ps.setInt( 2 , listsize);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 	rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getInt(6), 
						rs.getInt(7), 	rs.getInt(8), 	rs.getInt(9), 
						rs.getInt(10), 	rs.getString(11)	);
				list.add(dto);
			}// while end 
		}catch (Exception e) {System.out.println(e);} 
		return list;
	}
	// 3. 개별 게시물 조회 
	public BoardDto getBoard( int bno ) {
		String sql = " select board.* , member.mid , member.mimg "
				+ " from board natural join member where board.bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , bno );		rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 	rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getInt(6), 
						rs.getInt(7), 	rs.getInt(8), 	rs.getInt(9), 
						rs.getInt(10), 	rs.getString(11)	);
				return dto;
			}
		}catch (Exception e) {System.out.println(e);} 
		return null;
	}
	
}



























