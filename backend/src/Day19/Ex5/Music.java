package Day19.Ex5;

public class Music extends Thread {
	
	public boolean stop = false; // 작동 스위치
	
	@Override
	public void run() {
		while( stop ) {	// stop true이면 실행
			System.out.println(" --음악재생중-- ");
			try { Thread.sleep(1000);} catch (Exception e) {}
		}
	}
}
