package model.dao;

import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao; }
	
	// 1. 제품 등록 
	public boolean write( ProductDto dto ) {
		String sql ="insert into product(pname, pcomment, pprice, plat, plng)"
				+ " values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1 , dto.getPname() );	ps.setString(2 , dto.getPcomment() );
			ps.setLong(3 , dto.getPprice() );	ps.setString(4 , dto.getPlat() );
			ps.setString(5 , dto.getPlng() );	ps.executeUpdate(); return true;
		}catch (Exception e) { 	System.out.println(e); 	} return false;
	}
	
	// 2. 제품 호출
	public ArrayList<ProductDto> getProductList( String 동 , String 서 , String 남 , String 북 ){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql ="SELECT * FROM product where ? >= plng and ? <= plng and ? <= plat and ? >= plat ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , 동 );	ps.setString( 2 , 서 );	ps.setString( 3 , 남 );	ps.setString( 4 , 북 );
			
			rs = ps.executeQuery();
			while( rs.next() ) {
				list.add( new ProductDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getLong(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), 
						rs.getString(9) ) );
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
	
}
































