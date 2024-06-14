package co.yedam.common;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface - 구현객체
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchVO svo = new SearchVO(1, "T", "sql");
		
		mapper.boardListPaging(svo).forEach(bvo -> System.out.println(bvo));
	}
	
}
