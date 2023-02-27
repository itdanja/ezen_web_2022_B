package Day19.Ex3;

public class WorkThread extends Thread { 	// 1. 스레드 클래스 에게 상속받기 
	public boolean work = true; // 2. 필드
	public WorkThread( String name) { // 3. 생성자 
		setName(name);  // 스레드 이름 변경 
	}
	@Override
	public void run() { // 4.메소드[ Thread클래스의 run메소드 재정의 ]
		while(true) {	
			if( work ) {
				System.out.println( getName()+" : 작업처리 ");
			}else {
				Thread.yield();	// 스레드 양보 
			}
		}
	}
}
