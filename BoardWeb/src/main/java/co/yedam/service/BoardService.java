package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;
/* 
 * 목록, 단건조회, 등록, 수정, 삭제
 * 기능의 실행은 mapper 실행
 */
public interface BoardService {
	List<BoardVO> boardList();
	List<BoardVO> boardListPaging(SearchVO search);
	int boardTotal(SearchVO search);
	BoardVO getBoard(int bno);
	boolean insertBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
	
	//checkMember(id,pw)
	MemberVO checkMember(String id, String pw);
	boolean checkId(String id);
	boolean insertMember(MemberVO mvo);
	boolean deleteMember(String id);
	boolean updateMember(MemberVO mvo);
	
	//파일첨부 회원등록
	boolean addMemberImg(MemberVO mvo);
	
	List<MemberVO> memberList();
	boolean insertMemberAjax(MemberVO mvo);
}
