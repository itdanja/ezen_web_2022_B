package Day19.EX4;

public class User1Thread extends Thread {
	private Calculator calculator;	// 필드 
	public User1Thread() { // 생성자 
		setName("User1Thread"); // 스레드 이름 변경 
	}
	public void setCalculator( Calculator calculator) { // setter
		this.calculator = calculator;
	}
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
