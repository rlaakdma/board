package kr.or.ddit.comments.service;

import java.util.List;

import kr.or.ddit.comments.model.CommentsVo;

public interface CommentsServiceInf {
	
	/**
	 * Method : createcomments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param commentsVo
	 * @return
	 * Method 설명 : 댓글을 등록한다.
	 */
	int createcomments(CommentsVo commentsVo);
	
	/**
	 * Method : getComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param w_no
	 * @return
	 * Method 설명 : 댓글 정보 조회
	 */
	List<CommentsVo> getComments(int w_no);
}
