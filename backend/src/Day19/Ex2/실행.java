package Day19.Ex2;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. Thread 자식 클래스로 멀티스레드 구현 
		A a = new A();
		a.start();
		
		// 2. Thread 자식 클래스의 익명 객체로 구현 
		Thread thread = new Thread() {
			@Override
			public void run() {
				while( true ) {
					System.out.println( "[ 3.익명스레드1 실행중 ]" );
					try{ Thread.sleep(1000); } // 현 스레드 1초간 일시정지 
					catch (Exception e) {	}
				}
			}
		};
		thread.start();
		
		// 3. Runnable 인터페이스 구현 객체 구현 
		B b = new B();
		Thread thread2 = new Thread(b);
		thread2.start();
		
		// 4. Runnable 인터페이스의 익명 객체로 구현 
		Thread thread3 = new Thread( new Runnable() {
			@Override
			public void run() {
				while( true ) {
					System.out.println( "[ 5.익명스레드2 실행중 ]" );
					try{ Thread.sleep(1000); } // 현 스레드 1초간 일시정지 
					catch (Exception e) {	}
				}
			}
		});
		thread3.start();
		
		// 5. main 스레드 
		while( true ) {
			System.out.println( "[ 1.main스레드 실행중 ]" );
			try{ Thread.sleep(1000); } // 현 스레드 1초간 일시정지 
			catch (Exception e) {	}
		}
		
	}
}





