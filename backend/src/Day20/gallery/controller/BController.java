package Day20.gallery.controller;

import java.util.ArrayList;

import Day20.gallery.model.Dao.BoardDao;
import Day20.gallery.model.Dto.CategortDto;
import Day20.gallery.view.BoardView;

public class BController {

	private static BController bController = new BController();
	private BController() {}
	public static BController getInstance() { return bController;}
	
	// 1. 카테고리 추가 처리 
	public boolean categoryAdd( String cname ) {
		return BoardDao.getInstance().categoryAdd(cname);
	}
	
	// 2. 모든 카테고리 호출 처리 
	public ArrayList< CategortDto > categoryPrint(){
		return BoardDao.getInstance().categoryPrint();
	}
	
}
