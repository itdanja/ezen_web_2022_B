package 과제.과제4_싱글톤.model;

/*
 	model 관계
 		1. 한명의 회원이 글 작성한다.		[ object ]
 		2. 회원은 여러개의 글을 작성할수 있다.[ ArrayList ]
 		* 양방향 설정 [ * toString메소드 사용 불가 ]
 */

public class Board {

	// 1. 필드
	private String title;
	private String content;
	private int view;
	// 하나의 게시물[객체]가 하나의 member 객체를 가질수있다.
	private Member member;
	
	// 2. 생성자
	public Board() {}

	public Board(String title, String content, int view, Member member) {
		this.title = title;
		this.content = content;
		this.view = view;
		this.member = member;
	}
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", view=" + view + ", member=" + member + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
 
	
	
	
}
