package Day20.gallery.controller;

import Day20.gallery.model.Dao.MemberDao;
import Day20.gallery.model.Dto.MemberDto;

public class MController {

	private static MController mController = new MController();
	private MController() {}
	public static MController getInstance() { return mController;}

	
	// 1. 회원가입 처리 [ 아이디중복체크 ] 
	public int signup( String mid , String mpw , 
						String mname , String mphone   ) {
		// 1. 유효성검사 [ 글자수 , 중복체크 등등 ]
			// 1. 아이디 중복체크 
		if( MemberDao.getInstance().idCheck(mid) ) {
			return 2;	// 중복된 아이디 입니다. 함수 종료 
		}
		// 2. 객체화
		MemberDto dto = new MemberDto(0, mid, mpw, mname, mphone);
		// 3. 회원가입 DB처리 후 db처리 결과를 반환 
		return MemberDao.getInstance().signup(dto);
	}
	
	private int loginSession = 0; // 로그인된 회원번호 담기
	public int getLoginSession() { return loginSession; }
	
	// 2. 
	public boolean login( String mid , String mpw  ) {
		// 1. 유효성검사 
		// 2. 
		int result = 
		MemberDao.getInstance().login(mid, mpw);
		
		// 3. 로그인 성공 증거 [ 로그인 정보 저장소 = 세션 ]
		if( result == 0 ) { return false; }
		else {
			loginSession = result; // * 반환된 회원번호를 세션에 저장 
			return true;
		}
	}

}














