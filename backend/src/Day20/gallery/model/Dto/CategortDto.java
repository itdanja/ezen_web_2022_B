package Day20.gallery.model.Dto;

public class CategortDto {
	private int cno;
	private String cname;
	
	public CategortDto() {}

	public CategortDto(int cno, String cname) {
		super();
		this.cno = cno;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "CategortDto [cno=" + cno + ", cname=" + cname + "]";
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
    
}
