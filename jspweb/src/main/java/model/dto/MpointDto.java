package model.dto;

public class MpointDto {
	private int mpno;
	private String mpcomment;
	private int mpamount;
	private String mpdate;
	private int mno;
	
	public MpointDto() {
		// TODO Auto-generated constructor stub
	}
	public MpointDto(int mpno, String mpcomment, int mpamount, String mpdate, int mno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpamount = mpamount;
		this.mpdate = mpdate;
		this.mno = mno;
	}
	public int getMpno() {
		return mpno;
	}
	public void setMpno(int mpno) {
		this.mpno = mpno;
	}
	public String getMpcomment() {
		return mpcomment;
	}
	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}
	public int getMpamount() {
		return mpamount;
	}
	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}
	public String getMpdate() {
		return mpdate;
	}
	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mpcomment=" + mpcomment + ", mpamount=" + mpamount + ", mpdate=" + mpdate
				+ ", mno=" + mno + "]";
	}
	
}
