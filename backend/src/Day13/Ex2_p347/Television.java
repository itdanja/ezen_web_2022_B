package Day13.Ex2_p347;

public class Television implements RemoteControl {
	
	// 필드
	private int volume;
	
	// 1. 클래스명 implements 인터페이스명
		// 해당 클래스가 인터페이스에서 추상된 메소드를 구현하겠다!
	// 2. 필수: ! @오버라이딩
		// 구현한다고 했기때문에 해당 메소드를 오버라이딩 해서 구현하기
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) { // 만약에 요청한 소음이 최대소음보다 크면 
			this.volume = RemoteControl.MAX_VOLUME; // 현재소음에 최대소음을 대입 
			System.out.println(" 최대 소음보다 커질수 없습니다. 최대소음으로 설정  ");
		}else if( volume < RemoteControl.MIN_VOLUME ) { // 만약에 요청한 소음이 최소소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME;	// 현재소음에 최소소음을 대입 
			System.out.println(" 최소 소음보다 작아질수 없습니다. 최소소음으로 설정 ");
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume ); // 현재소음 출력 
	}
}
