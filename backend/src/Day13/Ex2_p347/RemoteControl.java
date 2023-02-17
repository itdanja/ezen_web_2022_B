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
	//1.
	public abstract void turnOn();	// { } 없다 
	void turnOff();	// public abstract 생략 가능 
	void setVolume( int volume );
	
}
