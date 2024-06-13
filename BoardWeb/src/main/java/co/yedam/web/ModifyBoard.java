package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();

		req.setCharacterEncoding("UTF-8");
		int page = Integer.parseInt(req.getParameter("page"));
		BoardVO bvo = svc.getBoard(Integer.parseInt(req.getParameter("boardNo")));
		
		bvo.setTitle(req.getParameter("title"));
		bvo.setContent(req.getParameter("content"));
		bvo.setWriter(req.getParameter("writer"));
		
		if(svc.editBoard(bvo)) {
			System.out.println("수정 성공");
			resp.sendRedirect("getBoard.do?boardNo="+ bvo.getBoardNo() +"&page=" + page);
		} else {
			System.out.println("수정 실패");
			resp.sendRedirect("boardList.do");
		}
		
		

	}

}
