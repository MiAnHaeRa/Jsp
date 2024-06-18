package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class RegistForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		name = name == null ? "" : name;
		String id = req.getParameter("id");
		id = id == null ? "" : id;
		String pw = req.getParameter("pw");
		pw = pw == null ? "" : pw;
		String checked = req.getParameter("checked");
		System.out.println("회원가입 창으로 넘어가는중 : " + checked);
		if(checked == null || checked.equals("") || checked.equals("false")) {
			checked =  "false";
		} else {
			checked = "true";
		}
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("checked", checked);
		
		req.getRequestDispatcher("member/registForm.tiles").forward(req, resp);
		
	}

}
