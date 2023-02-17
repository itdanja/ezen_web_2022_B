package Day13.Ex5_p376;

public class 실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		myCar.tire1 = new KumhoTire();
		myCar.tire2 = new KumhoTire();
		
		myCar.run();
	}
}
