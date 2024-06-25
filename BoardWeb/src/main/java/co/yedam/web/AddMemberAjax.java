package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMemberAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;	//5MB
		String encording = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encording, new DefaultFileRenamePolicy());
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String name = mr.getParameter("name");
		String img = mr.getFilesystemName("myImg");
//		String checked = req.getParameter("checked");
		
//		if(checked.equals("false") || checked == null) {
//			resp.sendRedirect("member/registForm.tiles");
//			return;
//		}
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setImg(img);
		
		BoardService svc = new BoardServiceImpl();

		try {
			if(svc.addMemberImg(mvo)) {
				if(req.getMethod().equals("POST")) {
					resp.sendRedirect("memberList.do");
				} else if(req.getMethod().equals("PUT")){
					resp.getWriter().print("{\"retCode\" : \"OK\" }");
				}
			}
		} catch (Exception e) {
			if(req.getMethod().equals("PUT")) {
				resp.getWriter().print("{\"retCode\" : \"NG\" }");
				e.printStackTrace();
			}
		}
		
	}

}
