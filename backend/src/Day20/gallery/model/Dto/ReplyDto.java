package Day20.gallery.model.Dto;

public class ReplyDto {

	private int rno	;
	private String rcontent;
	private String rdate;
	private int rindex;
	private String mid;
	private int	bno;
	
	public ReplyDto() {
		// TODO Auto-generated constructor stub
	}

	public ReplyDto(int rno, String rcontent, String rdate, int rindex, String mid, int bno) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.mid = mid;
		this.bno = bno;
	}

	@Override
	public String toString() {
		return "ReplyDto [rno=" + rno + ", rcontent=" + rcontent + ", rdate=" + rdate + ", rindex=" + rindex + ", mid="
				+ mid + ", bno=" + bno + "]";
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
    
}
