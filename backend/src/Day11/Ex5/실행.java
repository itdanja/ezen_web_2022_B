package Day11.Ex5;

import 과제.과제4_싱글톤.model.Member;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 자식 객체 만들기
		Child child = new Child();
			child.name ="유재석";
			child.job ="방송인";
		
		// --------- 자동 변환 -------------
		
		// 2. 자식 객체를 부모 객체로 이동[타입 변환 ]
		Parent parent = child;
		// 3. 
		parent.method1();
		parent.method2();
		// 부모 멤버인데 -> 자식이 오버라이딩한 메소드 사용
		// parent.method3(); // 자식 멤버 사용 불가 
		
		System.out.println( parent.name );
		// System.out.println( parent.job );
		
		// -------------- 강제 변환 ------------
		// 1. 부모 객체를 자식 객체로 이동[ 강제 타입 변환 ]
		Child child2 = (Child)parent;
		
		child2.method1();
		child2.method2();
		child2.method3();
		
		System.out.println( child2.name );
		System.out.println( child2.job );
		

		Object object = child;
		Member member = (Member)object;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
