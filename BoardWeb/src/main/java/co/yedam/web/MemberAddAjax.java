package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String uname = req.getParameter("uname");
		String upw = req.getParameter("upw");
		String auth = req.getParameter("auth");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(uid);
		mvo.setUserName(uname);
		mvo.setUserPw(upw);
		mvo.setResponsibility(auth);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.insertMemberAjax(mvo)) {	//{"retCode":"OK", "retMsg":"Success"}
			resp.getWriter().print("{\"retCode\":\"OK\", \"retMsg\":\"Success\"}");
		} else {	//{"retCode":"NG", "retMsg":"Fail"}
			resp.getWriter().print("{\"retCode\":\"NG\", \"retMsg\":\"Fail\"}");
		}

	}

}
