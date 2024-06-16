package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class RegistControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String checked = req.getParameter("checked");
		
		if(checked.equals(false)) {
			resp.sendRedirect("/member/registForm.tiles");
			return;
		}
		
		MemberVO mvo = new MemberVO();
		mvo.setUserName(name);
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.insertMember(mvo)) {
			System.out.println("회원가입 성공");
			req.getRequestDispatcher("/member/loginForm.tiles").forward(req, resp);
		} else {
			System.out.println("회원가입 실패");
			resp.sendRedirect("/member/registForm.tiles");
		}

	}

}
