package model.dto;

import java.util.List;

public class ProductDto {
	
    private int  pno;
    private String   pname;
    private String   pcomment;
    private long   pprice;
    private int   pstate;
    private String   plat;
    private String  plng;
    private int    pview;
    private String   pdate;
    // 추가 필드
    private int mno; // 등록한 회원번호
    private String mid; // 등록한 회원아이디
    private List<String> pimglist; // 등록한 사진목록들 
    
    // 등록용 생성자 [ 제품명 , 제품설명 , 제품가격 , 위도 , 경도 , 등록회원번호 , 등록사진목록 ]
    public ProductDto(String pname, String pcomment, long pprice, String plat, String plng, int mno,
			List<String> pimglist) {
		super();
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.pimglist = pimglist;
	}
    
    // 빈 필드 
    public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	// 풀 필드 
	public ProductDto(int pno, String pname, String pcomment, long pprice, int pstate, String plat, String plng,
			int pview, String pdate, int mno, String mid, List<String> pimglist) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.pstate = pstate;
		this.plat = plat;
		this.plng = plng;
		this.pview = pview;
		this.pdate = pdate;
		this.mno = mno;
		this.mid = mid;
		this.pimglist = pimglist;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcomment() {
		return pcomment;
	}
	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
	public long getPprice() {
		return pprice;
	}
	public void setPprice(long pprice) {
		this.pprice = pprice;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public String getPlng() {
		return plng;
	}
	public void setPlng(String plng) {
		this.plng = plng;
	}
	public int getPview() {
		return pview;
	}
	public void setPview(int pview) {
		this.pview = pview;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public List<String> getPimglist() {
		return pimglist;
	}
	public void setPimglist(List<String> pimglist) {
		this.pimglist = pimglist;
	}
	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcomment=" + pcomment + ", pprice=" + pprice
				+ ", pstate=" + pstate + ", plat=" + plat + ", plng=" + plng + ", pview=" + pview + ", pdate=" + pdate
				+ ", mno=" + mno + ", mid=" + mid + ", pimglist=" + pimglist + "]";
	}
    
    
    

}
