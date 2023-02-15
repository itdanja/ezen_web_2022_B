package 과제.과제6;
public class Tire {
	// 1. 필드
	public int maxRotation; 
	public int accumulatedRotation; 
	public String location;
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	public boolean roll() {
		++accumulatedRotation;
		if( accumulatedRotation < maxRotation ) {
			System.out.println( location + " Tire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" Tire 펑크 ***");
			return false; 
		}
	}
}
