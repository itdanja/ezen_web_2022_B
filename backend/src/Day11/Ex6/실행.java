package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {
		
		// * 타이어 
		Tire tire = new Tire(); // 기본타이어
		
		//1. 자동차 객체 만들기
		Car myCar = new Car();
		// 자동차 객체에 타이어 객체 1개 포함
		// 2. 기본 타이어 장착
		myCar.tire = new Tire();
		myCar.run();
			Tire result = myCar.parking(tire);
		// 3. 한국 타이어 교체
		myCar.tire = new HankookTire();
		myCar.run();
		
		HankookTire hankookTire = new HankookTire();
			HankookTire result2 =  (HankookTire) myCar.parking(hankookTire);
			
			System.out.println( result2 instanceof Tire );
			System.out.println( result2 instanceof Object );
			
		// 4. 금호 타이어 교체 
		myCar.tire = new KumhoTire();
		myCar.run();
			
		KumhoTire kumhoTire = new KumhoTire();
			KumhoTire result3 = ( KumhoTire)myCar.parking(kumhoTire);
	}
}




