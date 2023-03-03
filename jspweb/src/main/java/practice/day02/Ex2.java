package practice.day02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Dao에게 모든 데이터 요청 
		// ArrayList<Object> list = Dao.getInstance().getData();
		
		// 1. Dto 리스트로 받기 
		ArrayList<Dto> list = Dao.getInstance().getData2();
			// * JAVA객체 와 JS객체는 체계/형태 가 다르다 [ 호환 불가 ]
			// 해결 : JAVA객체를 JS객체 바꾸자 [ Object -> json ]
			// 1. 라이브러리 3개 [ jackson-databind-x , jackson-core-x , jackson-annotations-x ]
			// 2. ObjectMapper 객체 생성 [ jackson 라이브러리에서 제공 ] 
		ObjectMapper objectMapper = new ObjectMapper();
			// 3. objectMapper.writeValueAsString( 자바객체 ) ----> 자바객체를 JSON형식의 문자열 반환 
		String jsonArray = objectMapper.writeValueAsString( list );
			//System.out.println( list );	// 자바 객체 
				// [ 주소 , 주소 ]
			//System.out.println( jsonArray ); // 자바 객체가 json형식으로 문자열 변환 
				// [ { } , { } ]
		// 2. 요청으로 받은 결과를 JS에게 전달 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");	// 전달[전송]타입을 json 명시 
		response.getWriter().print( jsonArray ); 		// 변환된 json형식의 문자열 전달 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// * request : JS 요청 객체 
		// 1. 요청시 데이터 한글 인코딩 
		request.setCharacterEncoding("UTF-8");
		// 2. request.getParameter("매개변수명"); 	: 데이터 가져올때 무조건 String 타입 가져온다. [ 필요에 따라 형변환 ] 
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		double data3 = Double.parseDouble( request.getParameter("data3") );	// String --> double
		int data4 = Integer.parseInt( request.getParameter("data4") );
		String data5 = request.getParameter("data5");
		String data6 = request.getParameter("data6");
		String data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean( request.getParameter("data8") ) ;
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		
		// 3. DAO 메소드에 인수10개 전달
		// boolean result = Dao.getInstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		// 3. 변수10개 ---> DTO 1개 변환
		Dto dto = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		// 3-4 DAO 메소드에게 DTO 1개 전달
		boolean result = Dao.getInstance().setData2(dto);
		
		// * response : JS 응답 객체 
		// 4. 응답시 데이터 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 5. DAO 결과를 JS에게 전달하기 
		response.getWriter().print(result);
		
		
	}

}





























