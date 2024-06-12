package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoardForm;
import co.yedam.web.AddStudent;
import co.yedam.web.BoardList;
import co.yedam.web.GetBoard;
import co.yedam.web.MainControl;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyBoardForm;
import co.yedam.web.ProductControl;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveBoardForm;
import co.yedam.web.StudentForm;
import co.yedam.web.InsertBoard;

// front -> 요청url(*.do) - 실행컨트롤 매칭
// main.do -> FrontController -> /WEB-INF/public/main.jsp
// 객체생성 -> init -> service -> destroy
public class FrontController extends HttpServlet {
	
	private Map<String, Control> map;	//key : url, value : control
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		map.put("/StudentForm.do", new StudentForm());	//동록화면
		map.put("/addStudent.do", new AddStudent());	//db에 정보 저장
		
		//게시글 목록
		map.put("/boardList.do", new BoardList());		//목록
		map.put("/getBoard.do", new GetBoard());		//단권조회
		map.put("/addForm.do", new AddBoardForm());		//추가
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/modifyBoardForm.do", new ModifyBoardForm());	//업데이트
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/removeBoard.do", new RemoveBoard());	//삭제
		map.put("/removeBoardForm.do", new RemoveBoardForm());	
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();	// url : http://localhost/BoardWeb/main.do
//		System.out.println("uri : " + uri);	// uri : /BoardWeb/main.do
		String context = req.getContextPath();	//project name
//		System.out.println("context : " + context);	// context : /BoardWeb
		String page = uri.substring(context.length());
//		System.out.println("page : " + page);	// page : /main.do
		Control result = map.get(page);
		result.exec(req, resp);
	}
}
