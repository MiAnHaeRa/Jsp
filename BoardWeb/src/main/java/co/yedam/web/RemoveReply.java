package co.yedam.web;

import java.io.IOException;
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

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String rno = req.getParameter("rno");
		
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().create();
		
		try {
			ReplyService svc = new ReplyServiceImpl();
			if(svc.removeReply(Integer.parseInt(rno))) {
				map.put("retCode","Success");
				map.put("msg","삭제 성공하였습니다.");
			} else {
				map.put("retCode","Fail");
				map.put("msg","데이터가 존재하지 않거나 프로그램 오류로 삭제 실패했습니다.");
			}
		} catch (Exception e) {	//{"retCode":"Fail"}
			map.put("retCode","SQLFail");
			map.put("msg","프로그램 오류로 삭제 실패하였습니다.(SQL문)");
		}
		String json = gson.toJson(map);
		resp.getWriter().print(json);

	}

}
