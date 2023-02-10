package Day08.Ex3_p225;

public class Car {
	// 1.필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	// 2.생성자
		// 오버로딩 : 매개변수의 타입,개수,순서가 다르게 여러개 생성자 선언 
		// 오른쪽클릭 -> source -> Generate Constructor using Fields -> 필드선택
	// 1. 생성자 : 빈생성자	매개변수 없다 
	public Car() { }	
	// 2. 생성자 : 1개 매개변수  
	public Car(String model) {
		this.model = model;
	}
	// 3. 생성자 : 2개 매개변수 
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	// 4. 생성자 : 3개 매개변수 
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	// 5. 생성자 : 모든 필드받는 매개변
	public Car(String company, String model, String color, int maxSpeed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	// 3.메소드 
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
}
