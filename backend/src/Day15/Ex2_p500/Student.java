package Day15.Ex2_p500;

public class Student {
	private int no;
	private String name;
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Student ) {
			Student target = (Student)obj;
			if( no == target.getNo() 
					&& name.equals( target.getName() )) {
				return true;
			}
		}
		return false;
		
	}
	
	
	
	
	
}
