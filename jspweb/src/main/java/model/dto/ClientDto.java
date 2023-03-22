package model.dto;

import javax.websocket.Session;

public class ClientDto {
	
	private Session session;
	private String mid; // 접속한사람
	
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", mid=" + mid + "]";
	}
	
	
	
}
