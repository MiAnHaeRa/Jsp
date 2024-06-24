package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class RegistControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일첨부일 경우에는 multipart 요청을 처리
		//Multipart 요청(1.요청정보 2.저장위치 3.최대크기 4.인코딩 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encording = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encording, new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String img = mr.getFilesystemName("myImg");
//		String checked = req.getParameter("checked");
		
//		if(checked.equals("false") || checked == null) {
//			resp.sendRedirect("member/registForm.tiles");
//			return;
//		}
		
		MemberVO mvo = new MemberVO();
		mvo.setUserName(name);
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setImg(img);
		
		BoardService svc = new BoardServiceImpl();
		try {
			if(svc.addMemberImg(mvo)) {
				System.out.println("회원가입 성공");
				req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
			resp.sendRedirect("member/registForm.tiles");
		}

	}

}
