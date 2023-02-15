package Day11.Ex6;

public class Car {
	public Tire tire;
	public void run() {
		tire.roll();
	}
	public Tire parking( Tire tire ) {
		tire.stop();
		return tire;
	}
}
