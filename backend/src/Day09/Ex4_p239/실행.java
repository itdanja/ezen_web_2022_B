package Day09.Ex4_p239;

public class 실행 {
	public static void main(String[] args) {
		
		Calcuator myCalcu = new Calcuator();
		
		double result1 = myCalcu.areaRectangle(10);
		
		double result2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println( result1 );
		System.out.println( result2 );
		
		
	}
}
