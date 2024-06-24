package co.yedam.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		List<Map<String, Object>> map = mapper.centerBySido();
		Map<String, Integer> centerMap = new HashMap<String, Integer>();
		for (Map<String, Object> result : map) {
			System.out.println(result.get("SIDO") + ", " + result.get("CNT"));
			System.out.println("---------------------------------");
			centerMap.put((String) result.get("sido"), (Integer)result.get("cnt"));
		}
		
		
	}

}
