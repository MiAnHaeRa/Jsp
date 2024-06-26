package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

/*
 * oracle db에 글목록을 조회 -> boardList.jsp 출력.
 */
public class BoardList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page;
		int paging = Integer.parseInt(page);
		
		//검색조건을 담는 SearchVO
		SearchVO  search = new SearchVO(paging, sc, kw);
		BoardService svc = new BoardServiceImpl();
		
		List<BoardVO> list = svc.boardListPaging(search);
		
		req.setAttribute("boardList", list);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//paging 계산
		int totalCnt = svc.boardTotal(search);
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
	}

}
