package model.dto;

public class FriendDto {
	private int fno;
	private int ffrom;
	private int fto;
	
	public FriendDto() {
		// TODO Auto-generated constructor stub
	}

	public FriendDto(int fno, int ffrom, int fto) {
		super();
		this.fno = fno;
		this.ffrom = ffrom;
		this.fto = fto;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFfrom() {
		return ffrom;
	}

	public void setFfrom(int ffrom) {
		this.ffrom = ffrom;
	}

	public int getFto() {
		return fto;
	}

	public void setFto(int fto) {
		this.fto = fto;
	}

	@Override
	public String toString() {
		return "FriendDto [fno=" + fno + ", ffrom=" + ffrom + ", fto=" + fto + "]";
	}
	
}
