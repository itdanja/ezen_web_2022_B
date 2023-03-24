package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class Productinfo
 */
@WebServlet("/product/info")
public class Productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    ObjectMapper mapper = new ObjectMapper();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");	System.out.println(동);
		String 서 = request.getParameter("서");	System.out.println(서);
		String 남 = request.getParameter("남");	System.out.println(남);
		String 북 = request.getParameter("북");	System.out.println(북);
		
		
		ArrayList<ProductDto> result = ProductDao.getInstance().getProductList( 동 , 서 , 남 , 북 );
		
		String jsonarray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		MultipartRequest multi = new MultipartRequest(
				request, path , 1024*1024*10 , "UTF-8" , new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");						System.out.println( pname );
		String pcomment = multi.getParameter("pcomment");				System.out.println( pcomment );
		int pprice = Integer.parseInt( multi.getParameter("pprice") );	System.out.println( pprice );
		String plat = multi.getParameter("plat");						System.out.println( plat );
		String plng = multi.getParameter("plng");						System.out.println( plng );
		
		ProductDto dto  = new ProductDto(pname, pcomment, pprice, plat, plng);	System.out.println( dto );
		boolean result = ProductDao.getInstance().write(dto);
		response.getWriter().print(result);
	}

}































