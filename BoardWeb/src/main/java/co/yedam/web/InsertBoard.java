package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class InsertBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardService svc = new BoardServiceImpl();
		
		BoardVO bvo = new BoardVO();
		
		req.setCharacterEncoding("UTF-8");
		
		bvo.setTitle(req.getParameter("title"));
		bvo.setContent(req.getParameter("content"));
		bvo.setWriter(req.getParameter("writer"));
		
		if(svc.insertBoard(bvo)) {
			System.out.println("추가완료");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("추가실패");
			req.getRequestDispatcher("board/addBoardForm.tiles").forward(req, resp);
		}

	}

}
