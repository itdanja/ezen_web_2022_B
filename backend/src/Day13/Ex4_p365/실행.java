package Day13.Ex4_p365;

public class 실행 {
	public static void main(String[] args) {
		
		/*
		 		A엄마		B아빠
		 		   	 상속
		  			 C나
		 */
		
		
		// 1. 구현객체 만들기 
		InterfaceCImpl impl = new InterfaceCImpl();
		
		// 2. 인터페이스 변수에 구현객체 대입 
		InterfaceA ia = impl;
		ia.methodA(); 	// 본인 추상메소드 호출 가능 
		// ia.methodB();	// X
		// ia.methodC();	// X
		
		// 2. 
		InterfaceB ib = impl;
		//ib.methodA(); 		// X
		ib.methodB(); 			// 본인
		//ib.methodC(); 		// X
		
		// 2. 
		InterfaceC ic = impl;
		ic.methodA(); 		// o
		ic.methodB(); 		// o 
		ic.methodC();  		// o 
		
		
		
		
		
		
		
		
	}
}
