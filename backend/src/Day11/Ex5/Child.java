package Day11.Ex5;

public class Child extends Parent {
	public String job;
	@Override
	public void method2() {
		System.out.println("자식이 부모메소드2 재정의 ");
	}
	public void method3() {
		System.out.println("자식 메소드3 ");
	}
}
