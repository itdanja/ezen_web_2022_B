package Day20.gallery.model.Dao;

public class BoardDao extends Dao {

	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return dao;}
	
}
