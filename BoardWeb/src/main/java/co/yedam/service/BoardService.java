package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;
/* 
 * 목록, 단건조회, 등록, 수정, 삭제
 * 기능의 실행은 mapper 실행
 */
public interface BoardService {
	List<BoardVO> boardList();
	List<BoardVO> boardListPaging(int page);
	int boardTotal();
	BoardVO getBoard(int bno);
	boolean insertBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
}
