package 과제.과제5.모델링;

public class Product {
	// 관계 필드 = 참조 필드 [ FK ]
	private int mno;	// 등록한 회원의 번호
	// 관계 필드 = 식별용 [ pk ]
	private int pno; 	// 제품번호 
	// 일반 필드 
	private String title; 
	private String content;
	private String price; 
	private boolean state; 	// 제품상태 : 판매중 , 판매완료
	
}
