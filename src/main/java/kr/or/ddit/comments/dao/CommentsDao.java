package kr.or.ddit.comments.dao;

import java.util.List;

import kr.or.ddit.comments.model.CommentsVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CommentsDao implements CommentsDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : createcomments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param commentsVo
	 * @return
	 * Method 설명 : 댓글을 등록한다.
	 */
	@Override
	public int createcomments(CommentsVo commentsVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("comments.createcomments", commentsVo);
		session.commit();
		session.close();
		return insertCnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		List<CommentsVo> commentsVo = session.selectList("comments.getComments",w_no);
		session.close();
		return commentsVo;
	}
	
	/**
	 * Method : updateCnt
	 * 최초작성일 : 2018. 8. 1.
	 * 작성자 : user
	 * 변경이력 :
	 * @param c_no
	 * @return
	 * Method 설명 : 매개변수를 통해 댓글을 삭제한다.
	 */
	@Override
	public int updateCnt(int c_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("comments.updateCnt", c_no);
		session.commit();
		session.close();
		return updateCnt;
	}
}
