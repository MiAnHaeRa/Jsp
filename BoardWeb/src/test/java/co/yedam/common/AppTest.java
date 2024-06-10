package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface - 구현객체
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student std = new Student();
		
		//insert
//		std.setStdNo("S1004");
//		std.setStdName("김영식5");
//		std.setPhone("010-5555-1234");
//		std.setBldType("O");
//		
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
		
		//update
		std.setStdNo("S0102");
		std.setPhone("010-9191-7878");
//		
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudentPhone", std);
		mapper.updateStudentPhone(std);
		
		//delete
//		std.setStdNo("S1001");
//		sqlSession.delete("co.yedam.mapper.StudentMapper.deleteStudent", std);
		
		mapper.deleteStudent(std);
		sqlSession.commit();
		
//		List<Student> list = sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
		List<Student> list = mapper.selectBlog();
				
		for(Student std1 : list) {
			System.out.println(std1.toString());
		}
	}
	
}
