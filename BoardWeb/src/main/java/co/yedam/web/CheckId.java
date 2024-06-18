package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class CheckId implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		System.out.println("체크하는중 ID : " + id);
		if(id == null || id.equals("")) {
			req.getRequestDispatcher("member/registForm.tiles");
		}
		String name = req.getParameter("name");
		name = name == null ? "" : name;
		String pw = req.getParameter("pw");
		pw = pw == null ? "" : pw;
		String checked;
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.checkId(id)) {
			checked = "true";
			System.out.println("체크하는중 checked : " + checked);
			req.setAttribute("checked", checked);
			req.getRequestDispatcher("member/registForm.tiles").forward(req, resp);
		} else {
			checked = "false";
			System.out.println(checked);
			req.setAttribute("checked", checked);
			req.getRequestDispatcher("member/registForm.tiles").forward(req, resp);
		}

	}

}
