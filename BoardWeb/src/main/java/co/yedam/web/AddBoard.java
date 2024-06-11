package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		
		BoardVO bvo = new BoardVO();
		
		bvo.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));
		bvo.setTitle(req.getParameter("title"));
		bvo.setContent(req.getParameter("content"));
		bvo.setWriter(req.getParameter("writer"));
		
		svc.addBoard(bvo);

		resp.sendRedirect("boardList.do");
	}

}
