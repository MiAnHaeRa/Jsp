package co.yedam.book.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Control;

public class AddBook implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String company = req.getParameter("company");
		String price = req.getParameter("price");
		
		BookVO bvo = new BookVO();
		System.out.println(price);
		bvo.setAuthor(author);
		bvo.setBookCode(code);
		bvo.setBookTitle(title);
		bvo.setCompany(company);
		bvo.setPrice(Integer.parseInt(price));
		
		BookService svc = new BookServiceImpl();
		
		try {
			if(svc.addBook(bvo)) {	//{"retCode":"OK"}
				resp.getWriter().print("{\"retCode\":\"OK\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}

	}

}
