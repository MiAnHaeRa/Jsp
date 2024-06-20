package co.yedam.common;



import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		//interface에 구현해 메소드가 하나만 있는 인터페이스 : 함수형인터페이스
//		mapper.selectList(201).forEach(rvo -> {
//			System.out.println(rvo);
//		});
//		
//		ReplyVO rvo = mapper.selectReply(4);
//		System.out.println(rvo);
		
		ReplyVO rvo = new ReplyVO();
		
		rvo.setReply("댓글테스트");
		rvo.setReplyer("admin");
		rvo.setBoardNo(201);
		
		try {
			if(mapper.insertReply(rvo) == 1) {
				System.out.println("입력성공");
			} 
			
		} catch (Exception e) {
			System.out.println("예외발생");
		}
		
		try {
			if(mapper.deleteReply(6) == 1) {
				System.out.println("삭제성공");
			}
		} catch (Exception e) {
			System.out.println("삭제실패");
		}
		
		mapper.selectList(201).forEach(revo -> {
			System.out.println(revo);
		});
		
	}
	
}
