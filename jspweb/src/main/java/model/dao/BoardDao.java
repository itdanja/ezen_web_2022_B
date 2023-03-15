package model.dao;

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
}
