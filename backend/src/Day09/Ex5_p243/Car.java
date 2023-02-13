package Day09.Ex5_p243;

/*
 
 	객체 내부 멤버 호출시 this
 		* 다른 변수/메소드/생성자 와 이름이 동일할때 식별용도 
 		1. 내부 필드 호출 this.필드명
 		2. 내부 함수 호출 this.함수명()
 		3. 내부 생성자 호출 this( )
 */

public class Car {
	// 인스턴스 멤버 
	// 1. 필드
	String model;
	int speed;
	// 2. 생성자
	Car( String model ){ // model : 매개변수
		this.model = model;
		// 멤버필드 = 매개변수 
	}
	// 3. 메소드
	void setSpeed( int speed ) {
		this.speed = speed;
		// 멤버필드 = 매개변수 
	}
	
	void run() {
		this.setSpeed(100);
		System.out.println( this.model +"가 달립니다.(시속:"+this.speed+"km/h");
	}
}
