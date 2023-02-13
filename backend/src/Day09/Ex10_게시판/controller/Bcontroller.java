package Day09.Ex10_게시판.controller;

public class Bcontroller {

	// 1. 싱글톤 객체 
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {
		return bc;
	}
	
}
