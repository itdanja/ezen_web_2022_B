package Day20.gallery.model.Dao;

public class MemberDao extends Dao {

	// 1. 싱글톤 [ 내부에 본인객체 만든다. ]
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao;}
	
}
