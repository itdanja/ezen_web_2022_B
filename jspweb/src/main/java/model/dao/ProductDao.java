package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao; }
	
	// 1. 제품 등록 
	public boolean write( ProductDto dto ) {
		// 1. 제품 우선 등록 
		String sql ="insert into product(pname, pcomment, pprice, plat, plng , mno )"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString(1 , dto.getPname() );	ps.setString(2 , dto.getPcomment() );
			ps.setLong(3 , dto.getPprice() );	ps.setString(4 , dto.getPlat() );
			ps.setString(5 , dto.getPlng() );	ps.setInt( 6 , dto.getMno() );
			ps.executeUpdate();  
			// insert 후 생성된 제품pk번호 호출 [ pno 구하기 ]
			rs = ps.getGeneratedKeys();
			if( rs.next() ) { // 만약에 생성된 제품 pk번호가 존재하면 
				// dto내 첨부파일명 리스트에서 하나씩 첨부파일명을 insert 하기
				for( String pimgname : dto.getPimglist() ) {
					sql = "insert into pimg( pimgname , pno ) values(?,?)";
					ps = con.prepareStatement(sql);
					ps.setString( 1 ,pimgname ); ps.setInt( 2 , rs.getInt(1) );
					ps.executeUpdate();
					
				}
			}
			return true;
		}catch (Exception e) { 	System.out.println(e); 	} return false;
	}
	
	// 2. 제품 호출
	public ArrayList<ProductDto> getProductList( String 동 , String 서 , String 남 , String 북 ){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql ="SELECT p.* , m.mid , m.mimg FROM product p natural join member m "
				+ " where ? >= p.plng and ? <= p.plng and ? <= p.plat and ? >= p.plat ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , 동 );	ps.setString( 2 , 서 );	ps.setString( 3 , 남 );	ps.setString( 4 , 북 );
			
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				// 사진 레코드 호출 
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select * from pimg where pno = "+rs.getInt(1); // 동일한 제품번호의 이미지들을 호출
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				
				while( rs2.next() ) {
					pimglist.add( rs2.getString(2) );	// 검색된 이미지이름을 리스트에 저장 
				}
				
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9), 
						rs.getInt(10), rs.getString(11), rs.getString(12), pimglist );
				
				list.add( dto );
			}
		}catch (Exception e) { 	System.out.println(e); 	} return list;
	}
	
	// 3. 찜하기 등록/취소 
	public boolean setplike( int pno , int mno ) {
		// 1. 등록할지 취소할지 검색 먼저하기 
		String sql ="select * from plike where pno = "+pno+" and mno = "+mno;
		try {
			ps = con.prepareStatement(sql);	rs = ps.executeQuery();
			if( rs.next() ) { // 해당 회원이 이미 찜하기를 한 제품 ---> 취소하기 
				sql = "delete from plike where pno = "+pno+" and mno = "+mno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return false;	// 취소 되었을떄
			}else {	// 해당 회원이 찜하기를 하지 않은 제품 ----> 등록하기 
				sql = "insert into plike( pno , mno )values( "+pno+" , "+mno+" )";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;	// 등록 되었을때
			}
		}catch (Exception e) { 	System.out.println(e); 	}  return false;
	}
	// 4. 현재 회원이 해당 제품의 찜하기 상태 확인 
	public boolean getplike( int pno , int mno ) {
		String sql ="select * from plike where pno = "+pno+" and mno = "+mno;
		try {
			ps = con.prepareStatement(sql);	rs = ps.executeQuery();
			if( rs.next() ) { return true; }
		}catch (Exception e) { 	System.out.println(e); 	}  return false;
	}
	
	// 5. 제품에 채팅 등록 
	public boolean setChat ( ChatDto dto ) {
		String sql = "insert into note( ncontent , pno , frommno , tomno )values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 ,  dto.getNcontent() ); 
			ps.setInt( 2 ,  dto.getPno() );	ps.setInt( 3 ,  dto.getFrommno() );	ps.setInt( 4 ,  dto.getTomno() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) { 	System.out.println(e); 	}  return false;
	} // end 
	
	// 6. 제품에 등록된 채팅 출력 [ 제품번호 일치 , 현재 보고 있는 회원[로그인된회원] 받거나 보낸 내용들 ]
	public ArrayList<ChatDto> getChatList( int pno , int mno , int chatmno ){
		ArrayList<ChatDto> list = new ArrayList<>();
		// String sql = " select * from note where pno = ? and ( frommno = ? or tomno = ? )";
		// 현재 같이 채팅 하고 있는 대상자들 의 내용물만 출력 
		String sql = " select * from note where pno = ? and "
				+ " ( ( frommno = ? and tomno = ? ) or  (frommno = ? and tomno = ? ) )";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , pno );	
			ps.setInt( 2 , mno );		ps.setInt( 3 , chatmno );
			ps.setInt( 4 , chatmno );	ps.setInt( 5 , mno );
			
			rs = ps.executeQuery();
			while( rs.next() ) {
				ChatDto dto =  new ChatDto( 	rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6));
				// 보낸회원의 정보 호출 
				sql ="select mid , mimg from member where mno = " + rs.getInt(5);	// rs.getInt(5) = frommno
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				if( rs2.next() ) { 
					dto.setFrommid( rs2.getString(1) );
					dto.setFrommimg( rs2.getString(2));
				}
				list.add(  dto  );
			}
		}catch (Exception e) { 	System.out.println(e); 	}  
		return list;
	}
}

















/*
	- 1. 로그인된 회원기준으로 보내거나 받은 메시지 모두 출력 
		select * from note where pno = ? and ( frommno = ? or tomno = ? )
		1. 구매자 문제 없음 2.판매자는 채팅 대상만의 메시지만 출력 해야함 문제 발생 
	- 2.
		만약에 채팅방에 4번회원 과 5번회원 존재
		frommno = 4 이면서 tomno = 5		이거나		frommno = 5 이면서 tomno = 4
		- 4번회원이 보냈거나 받았으면 5번회원이 받았거나 보냈으면
*/














