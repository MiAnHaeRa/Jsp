package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();

		req.setCharacterEncoding("UTF-8");
		if(svc.removeBoard(Integer.parseInt(req.getParameter("bno")))) {
			System.out.println("삭제완료");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("삭제중 오류");
		}
		
		

	}

}