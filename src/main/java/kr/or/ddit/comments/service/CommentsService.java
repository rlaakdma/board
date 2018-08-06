package kr.or.ddit.comments.service;

import java.util.List;

import kr.or.ddit.comments.dao.CommentsDao;
import kr.or.ddit.comments.dao.CommentsDaoInf;
import kr.or.ddit.comments.model.CommentsVo;

public class CommentsService implements CommentsServiceInf {

	/**
	 * Method : createcomments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param commentsVo
	 * @return
	 * Method 설명 : 댓글을 작성한다.
	 */
	@Override
	public int createcomments(CommentsVo commentsVo) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.createcomments(commentsVo);
	}

	/**
	 * Method : getComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param w_no
	 * @return
	 * Method 설명 : 댓글 정보 조회
	 */
	@Override
	public List<CommentsVo> getComments(int w_no) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.getComments(w_no);
	}

	@Override
	public int updateCnt(int c_no) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.updateCnt(c_no);
	}
}