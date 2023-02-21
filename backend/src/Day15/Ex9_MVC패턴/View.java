package Day15.Ex9_MVC패턴;

public class View {
	// 싱글톤 
	private static View view = new View();
	private View() { }
	public static View getInstance() { return view; }
	
	public void index() {
		System.out.println("1.회원등록 :");
	}
	public void signup() {}
	
}
