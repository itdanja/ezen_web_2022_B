package 과제.과제11;

public class Controller {
	
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance( ) { 
		return con; 
	} 

}
