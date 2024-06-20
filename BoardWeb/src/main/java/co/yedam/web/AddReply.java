package co.yedam.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class AddReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");

		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);

		ReplyService svc = new ReplyServiceImpl();
		Gson gson = new GsonBuilder().create();
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (svc.registerReply(rvo)) {
				rvo.setReplyDate(new Date());

				map.put("retCode", "Success");
				map.put("retVal", rvo);
				map.put("msg", "등록 성공하였습니다.");
			}
		} catch (Exception e) { // {"retCode":"Fail"}
			e.printStackTrace();
			map.put("retCode", "SQLFail");
			map.put("msg", "프로그램 오류로 등록 실패하였습니다.(SQL문)");
		}
		
		resp.getWriter().print(gson.toJson(map));

	}

}
