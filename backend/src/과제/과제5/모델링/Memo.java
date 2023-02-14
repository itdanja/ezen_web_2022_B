package 과제.과제5.모델링;

public class Memo {
	// 관계필드 = 참조필드 [ fk ] 
	private int frommno; 	// 쪽지를 보낸 회원 번호 
	// 관계필드 = 참조필드 [ fk ] 
	private int pno; 		// 받는사람 + 현재 쪽지의 제품정보
	// 관계필드 = 식별용 [ pk ]
	private int meno;		// 쪽지번호
	// 일반필드 
	private String content; 
}

