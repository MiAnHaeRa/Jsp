package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

/*
 * 업무프로세스를 따라 실행하기 위한 서비스 
 */
public class BoardServiceImpl implements BoardService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);	//true넣으면 자동 commit
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList() {
		// mapper에 등록된 기능
		return mapper.boardList();
	}

	@Override
	public List<BoardVO> boardListPaging(SearchVO search) {
		return mapper.boardListPaging(search);
	}

	@Override
	public int boardTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
	
	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean insertBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public List<MemberVO> selectMember() {
		// TODO Auto-generated method stub
		return mapper.selectMemberAll();
	}
	
	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		return mapper.checkId(id) == 1;
	}

	@Override
	public boolean insertMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.insertMember(mvo) == 1;
	}
	
	@Override
	public boolean deleteMember(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteMember(id) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return mapper.memberList();
	}

	@Override
	public boolean insertMemberAjax(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.insertMemberAjax(mvo) == 1;
	}

	@Override
	public boolean updateMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.updateMember(mvo) == 1;
	}

	@Override
	public boolean addMemberImg(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.insertMemberImg(mvo) == 1;
	}
}
