package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class StudentForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청정보 : " + req + ", 응답정보 : " + resp);
		
		req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);

	}

}
