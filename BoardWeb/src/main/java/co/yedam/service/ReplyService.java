package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	//목록, 단건, 입력, 삭제
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(int boardNo, int page);
	ReplyVO getReply(int replyNo);
	boolean registerReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
	
	//댓글 건수
	int getTotalCnt(int bno);
}
