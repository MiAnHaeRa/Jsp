package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveBoardForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		req.setCharacterEncoding("UTF-8");
		BoardVO bvo = svc.getBoard(Integer.parseInt(req.getParameter("bno")));
		
		req.setAttribute("bvo", bvo);

		req.getRequestDispatcher("WEB-INF/view/removeBoardForm.jsp").forward(req, resp);

	}

}
