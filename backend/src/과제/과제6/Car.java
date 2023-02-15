package 과제.과제6;

public class Car {
	// 1. 필드 [ 변수 , 객체 , 상수 , 배열, 리스트 등 = 메모리 ]
	Tire frontLeftTire = new Tire( 6 , "앞왼쪽");
	Tire frontRightTire = new Tire(2 , "앞오른쪽");
	Tire backLeftTire =  new Tire(3 , "뒤왼쪽");
	Tire backRightTire =  new Tire(4 , "뒤오른쪽");
	
	// 3. 메소드 
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if( frontLeftTire.roll() == false ) { stop(); 	return 1; }
		if( frontRightTire.roll() == false ){ stop(); 	return 2; }
		if( backLeftTire.roll() == false ) 	{ stop(); 	return 3; }
		if( backRightTire.roll() == false ) { stop(); 	return 4; }
		return 0;
	}
	void stop() {System.out.println("[자동차가 멈춥니다.]");}
}
