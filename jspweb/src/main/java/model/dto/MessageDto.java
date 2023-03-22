package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.dao.MemberDao;

public class MessageDto {
	
	private String frommid;			// 메시지 보낸회원아이디;
	private String frommimg;		// 메시지 보낸회원프로필사진;
	private String msg;				// 메시지 내용
	private String time;			// 메시지 보낸시간 
	
	public MessageDto() {
		
	}
	
	// 클라이언트 에게 메시지 전송할때 사용하는 생성자 
	public MessageDto( Session session ,  String msg) {
	
		this.msg = msg;
		// 메시지를 보낸 클라이언트세션를 통해서 회원아이디 얻기 
		for( ClientDto dto : Chatting.접속명단 ) {
			if( dto.getSession() == session ) {
				this.frommid = dto.getMid();
				// 보낸사람의 프로필 얻기 
				this.frommimg = MemberDao.getInstance().getMember( this.frommid ).getMimg();
				// 메시지 [메시지객체] 생성된 날짜
				// 1. 
				Date date = new Date();	// 오늘날짜/시간 객체
				SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm"); // 날짜/시간 형식 
				this.time = sdf.format( date );	// 오늘객체를 정의한 형식으로 형변환
				// 2.
				// this.time = new SimpleDateFormat("hh:mm:ss").format( new Date() );
			}
		} // end 
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MessageDto [frommid=" + frommid + ", frommimg=" + frommimg + ", msg=" + msg + ", time=" + time + "]";
	}

	
}
