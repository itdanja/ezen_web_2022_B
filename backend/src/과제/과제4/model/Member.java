package 과제.과제4.model;
// * 데이터 모델링
public class Member {
	// 1. 필드 
	String id;
	String pwd;
	String name;
	String phone;
	// 2. 생성자
	public Member() { }
	public Member(String id, String pwd, String name, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
	}
	// 3. 메소드 
}
