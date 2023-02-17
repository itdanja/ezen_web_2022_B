package Day13.Ex6_예시;

public class 마법사 extends 캐릭터 {
	
	int 체력;
	int 마법력;
	
	@Override
	void 스킬1() {
		System.out.println("불공격");
	}
	@Override
	public void A버튼() {
		스킬1();
	}
}
