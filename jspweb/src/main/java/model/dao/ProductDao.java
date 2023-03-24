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
	public ArrayList<ProductDto> getProductList(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql ="select * from product ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				list.add( new ProductDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getLong(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), 
						rs.getString(9) ) );
			}
		}catch (Exception e) { 	System.out.println(e); 	} return list;
	}
	

}

















