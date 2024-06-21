package co.yedam.common;



import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		mapper.selectListPaging(324, 5).forEach(reply -> System.out.println(reply));
		
	}
	
}
