package controller.admin;

import java.io.IOException;

import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;
//URL 매개변수받을때 : /경로/{매개변수1}/{매개변수2} 
@ServerEndpoint("/chatting/{mid}")// 해당 클래스를 서버소켓[종착점] 으로 만들기	
public class Chatting {
	// 클라이언트 소켓이 접속했을때의 실행되는 메소드/함수 
	
	// *-* 접속한 클라이언트명단[목록] ( 클라이언트소켓 여러개 저장 )
	public static ArrayList< ClientDto > 접속명단 = new ArrayList<>();
	
	@OnOpen		// session[ 접속한 클라이언소켓 객체 ] // 서버 엔드포인트의 URL 매개변수[ @PathParam ]  가져오기 
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println(" 클라이언트 웹소켓 이 들어왔다. ");
		System.out.println( session );
		// 접속한 클라이언트소켓 들을 보관 
		접속명단.add( new ClientDto( session , mid ) );
		System.out.println( 접속명단.toString() );
	}
	
	@OnClose 	// 클라이언트소켓이 나갔을때
	public void onClose( Session session ) {
		System.out.println(" 클라이언트 웹소켓이 나갔습니다. ");
		접속명단.remove(접속명단);	// 접속 명단에서 제외 시키지
	}
	
	// 클라이언트 소켓이 메시지를 보냈을때[ 서버가 메시지 받기 ]
	@OnMessage // [ Session[누가] , String[내용물] ]
	public void onMessage( Session session , String msg ) throws Exception {
		System.out.println(" 클라이언트 웹소켓이 메시지를 보냈다. [서버가 메시지를 받았다.]");
		System.out.println( msg );
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기 
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달 
		for( Session s : 접속명단 ) {
			s.getBasicRemote().sendText(msg);	// ---> 클라이언트소켓.onmessage
		}
		
	}
	
}



