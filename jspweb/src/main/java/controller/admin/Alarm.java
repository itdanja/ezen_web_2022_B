package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	private static ArrayList<ClientDto> 알림명단 = new ArrayList<>();
	@OnOpen // 클라이언트 소켓이 들어왔을떄 매핑[연결]
	public void 서버입장( Session session , @PathParam("mid") String mid ) throws Exception {
		알림명단.add( new ClientDto( session , mid) );
	}
	@OnClose // 클라이언트 소켓이 나갔을때 매핑[연결]
	public void 서버나가기( Session session ) throws Exception { 
		for( ClientDto c : 알림명단  ) {
			if( c.getSession() == session ) { 알림명단.remove( c ); }
		}
	}
	@OnError // 클라이언트 소켓이 에러가 발생했을떄 매핑[연결] !!! 필수로 정의할 인수
	public void 서버오류( Session session , Throwable e ) throws Exception { System.out.println( e ); }
	
	@OnMessage // 클라이언트 소켓이 메시지를 보냈을때  매핑[연결] !!! 필수로 정의할 인수
	public static void 서버메시지( Session session , String msg ) throws Exception { 
		// 메시지를 받는 회원번호 
		int tomno = Integer.parseInt( msg.split(",")[0] );
		// 메시지 내용 
		String tomsg = msg.split(",")[1];
		
		for( ClientDto c : 알림명단 ) {
			// 현재 소켓의 접속된 회원명단의 아이디로 회원번호 구하기 
			int cmno =  MemberDao.getInstance().getMember( c.getMid() ).getMno();
			if( cmno == tomno ) { // 받는 회원번호가 알림명단에 존재하면
				c.getSession().getBasicRemote().sendText( tomsg );
			}
		}
	}
}

/*
 
 	Session session : 요청한 클라이언트 소켓의 변수 
 	Throwable e 	: 에러 발생시 에러이유가 저장된 변수 
 	String msg 		: 요청받은 메시지 내용
 	
 	서버소켓 
 		1. 	@ServerEndpoint("서버소켓경로/{매개변수명1}/{매개변수명2}")
 		2.	@OnOpen			필수 매개변수 : Session session
 		3. 	@OnClose		필수 매개변수 : Session session
 		4.	@OnError		필수 매개변수 : Session session , Throwable e 
 		5.	@OnMessage		필수 매개변수 : Session session , String s 
 		6.	@PathParam("경로상의{매개변수명}") 	: 경로상의 변수 요청 
  
 */














