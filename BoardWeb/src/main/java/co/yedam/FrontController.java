package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.MainControl;
import co.yedam.web.ProductControl;

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
//		map.put("/board.do", "게시판 페이지입니다");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();	// url : http://localhost/BoardWeb/main.do
		System.out.println("uri : " + uri);	// uri : /BoardWeb/main.do
		String context = req.getContextPath();	//project name
		System.out.println("context : " + context);	// context : /BoardWeb
		String page = uri.substring(context.length());
		System.out.println("page : " + page);	// page : /main.do
		
		Control result = map.get(page);
		result.exec(req, resp);
	}
	
}
