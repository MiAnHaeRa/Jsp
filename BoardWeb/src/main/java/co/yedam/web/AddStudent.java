package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.StudentService;
import co.yedam.service.StudentServiceImpl;
import co.yedam.vo.Student;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청정보 : " + req + ", 응답정보 : " + resp);
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		req.setCharacterEncoding("UTF-8");
		
		StudentService svc = new StudentServiceImpl();
		
		Student std = new Student();
		std.setStdNo(req.getParameter("stdNo"));
		std.setStdName(req.getParameter("stdName"));
		std.setPhone(req.getParameter("phone"));
		std.setBldType(req.getParameter("bldType"));
		
		if(svc.addStudent(std)) {
			System.out.println("정상등록...");
			resp.sendRedirect("main.do");
		} else {
			req.setAttribute("message", "처리중 오류가 발생");
			System.out.println("등록실패...");
			req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		}
		

	}

}
