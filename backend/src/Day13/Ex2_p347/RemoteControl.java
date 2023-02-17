package Day13.Ex2_p347;

public interface RemoteControl {
	// 상수 필드  [ 인터페이스는 변수 x ]
		// new 연산자[ 생성자 X ] -> 객체 X -> 인스턴스멤버X -> static 멤버만 가능
		// 상수 : public static final 	// 고정된 값o -> 초기값 필수 : 변수 선언시 값 대입 
		// 인터페이스 에서는 생략 --> 자동으로 선언됨
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0 ;	// 자동으로 public static final 
	
	// 추상메소드 
		// 리턴타입 , 메소드명 , 매개변수 만 선언 
		// { } 선언 안한다.
		// public abstract 생략 가능  --> 자동으로 선언됨
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 필수
	//1.
	public abstract void turnOn();	// { } 없다 
	void turnOff();	// public abstract 생략 가능 
	void setVolume( int volume );
	
	// 디폴트 메소드 
		// 클래스에서 사용하는 메소드 동일 [ 선언 과 구현 ] 
		// 선언부 앞에 default 선언 
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 선택
	// 2. 
	default void setMute( boolean mute ) {
		if( mute ) {
			System.out.println(" 무음 처리합니다. ");
			setVolume( MIN_VOLUME );
		}else {
			System.out.println(" 무음 해제합니다.");
		}
	}
	
	// 정적 메소드 
		// 구현객체가 필요없다.. implements 없이 가능 
		// static 선언 
		// implements 없이 사용하는 메소드
	// 3. 
	static void changeBattery( ) {
		System.out.println("리모콘 건전지를 교환합니다. ");
	}
	
	
	
}
























