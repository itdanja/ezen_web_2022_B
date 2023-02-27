package Day19.EX4;

public class User2Thread extends Thread {
	private Calculator calculator; // 필드 
	public User2Thread() { // 생성자 
		setName("User2Thread");
	}
	public void setCalculator( Calculator calculator ) { // setter
		this.calculator = calculator;
	}
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
