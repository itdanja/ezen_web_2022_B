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
		MemberDto dto = 
				new MemberDto(0, mid, mpw, mname, mphone);
		
		// 3. 회원가입 DB처리 후 db처리 결과를 반환 
		return MemberDao.getInstance().signup(dto);
		
	}


}
