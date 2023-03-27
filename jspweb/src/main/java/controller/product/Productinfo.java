package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
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
		
		// ----------------- commons.jar 사용시 --------------------// 
		
		request.setCharacterEncoding("UTF-8");// * 요청 한글타입
		
		// 1. 다운로드 할 서버 경로 
		String 경로 = request.getSession().getServletContext().getRealPath("/product/pimg");
		// 2. 해당 경로의 파일/폴더 객체화 [ setRepository 에서 대입하기 위해 ]
		File 저장경로객체 = new File( 경로 );
		
		// 3. 업로드할 저장소 객체 생성 
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository( 저장경로객체 );			// 파일저장소 위치 대입 
		파일저장소.setSizeThreshold( 1024*1024*10 );	// 파일저장소에 저장할수 있는 최대용량 범위
		파일저장소.setDefaultCharset("UTF-8");			// 파일저장소 한글 인코딩 타입
		
		// 4.파일업로드객체 
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소);
		
		try {
			// 5. 매개변수 요청해서 리스트에 담기 [ 무조건 예외처리 발생 ]  
			List<FileItem> 파일아이템목록 = 파일업로드객체.parseRequest(request);
				// * DB에 저장할 데이터를 분류
				List<String> 일반필드목록 = new ArrayList<>();
				List<String> 파일필드목록 = new ArrayList<>();
			// 6.
			for( FileItem item : 파일아이템목록 ) {	// 요청된 모든 매개변수들을 반복문 돌려서 확인 
				
				if( item.isFormField() ) { // .isFormField() : 첨부파일 아니면 true 첨부파일이면 false 
					System.out.println(" [첨부파일 아닌 필드명 : " + item.getFieldName() );
					System.out.println(" [첨부파일 아닌 필드의 값  : " + item.getString() );
					일반필드목록.add( item.getString() ); // 입력받은 값을 요청해서 리스트 저장 
				}else {
					System.out.println(" [첨부파일 인 필드명 : " + item.getFieldName() );
					System.out.println(" [첨부파일 인 필드의 파일명 : " + item.getName() );
					// 9. 첨부파일 이름를 식별이름 으로 변경 
						// 1. 파일명의 공백이 존재하면 - 로 변경 [ .replaceAll("기존문자","새로운문자") 문자열 치환함수 ] 
						// 2. UUID : 범용 고유 식별자 [ 중복이 없는 식별자 만들기 ]
						// 최종 식별 파일명 : UUID 파일명
					String filename = UUID.randomUUID() +" "+ ( item.getName().replaceAll(" ", "-") );
					
					파일필드목록.add(filename); // 첨부된 파일의 이름을 요청해서 리스트 저장 
					
					// 7. 저장할 경로 + / + 파일명 의 파일을 객체화 
					File 업로드할파일경로 = new File( 경로+"/"+filename );
					// 8. 해당 경로에 item 업로드 하기 
					item.write( 업로드할파일경로 );
				}
			}
			// 
			System.out.println( 일반필드목록.toString() );	System.out.println( 파일필드목록.toString() );
			
			// 제품등록한 회원번호 
			int mno = MemberDao.getInstance().getMno( 
					(String)request.getSession().getAttribute("login") );
			// dto 구성 
			ProductDto dto = new ProductDto( 
					일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt( 일반필드목록.get(2) ) , 
					일반필드목록.get(3), 일반필드목록.get(4) , mno , 파일필드목록 );
			System.out.println( "dto : " + dto.toString() );
			// dao 
			boolean result = ProductDao.getInstance().write(dto);
			response.getWriter().print(result);
			
		}catch (Exception e) { 	System.out.println(" 파일저장 실패 "+e); }
		
		
		
		
		// ----------------- cos.jar 사용시 ------------------------// 
		
		/*
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		MultipartRequest multi = new MultipartRequest(
				request, path , 1024*1024*10 , "UTF-8" , new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");						System.out.println( pname );
		String pcomment = multi.getParameter("pcomment");				System.out.println( pcomment );
		int pprice = Integer.parseInt( multi.getParameter("pprice") );	System.out.println( pprice );
		String plat = multi.getParameter("plat");						System.out.println( plat );
		String plng = multi.getParameter("plng");						System.out.println( plng );
		
		// 첨부파일 1개 이름 가져오기		multiple x 
		String pfile = multi.getFilesystemName("pfile");
			System.out.println( pfile );
			
		// 첨부파일 여러개 이름 가져오기 1 	multiple x 
		String pfile1 = multi.getFilesystemName("pfile1");
		String pfile2 = multi.getFilesystemName("pfile2");
		String pfile3 = multi.getFilesystemName("pfile3");
		
		// 첨부파일 여러개 이름 가져오기 2 	multiple o
			// multiple input 에 등록된 여러 사진들의 이름 가져오기 불가능 [ cos.jar 제공x ]
			// 다른 라이브러리 사용 
		Enumeration pfiles = multi.getFileNames();	// input type이 file의 태그명 호출
		
		while( pfiles.hasMoreElements() ) {
			// 해당 목록[pfiles] 에 요소[element]가 존재하면 true / 아니면 false 
			String s = (String)pfiles.nextElement();	// 다음 요소 가져오기 
			System.out.println( "s : "+ s );
		}
		
		
		ProductDto dto  = new ProductDto(pname, pcomment, pprice, plat, plng);	System.out.println( dto );
		boolean result = ProductDao.getInstance().write(dto);
		response.getWriter().print(result);
		*/
		
	}

}































