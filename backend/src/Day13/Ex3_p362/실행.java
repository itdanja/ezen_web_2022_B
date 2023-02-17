package Day13.Ex3_p362;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 구현객체
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		// 2. 구현객체
		Searchable searchable = new SmartTelevision();
		searchable.search("youtube");
		
	}

}
