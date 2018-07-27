package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * Method : getAllboard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시판을 조회한다.
	 */
	@Override
	public List<BoardVo> getAllboard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllboard");
		session.close();
		
		return boardList;
	}

	/**
	 * Method : getYboard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 활성화 게시판을 조회한다.
	 */
	@Override
	public List<BoardVo> getYboard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getYboard");
		session.close();
		
		return boardList;
	}
	
	/**
	 * Method : createboard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 활성화 혹은 비활성화 게시판을 생성한다.
	 */
	@Override
	public int createboard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("board.createboard", boardVo);
		session.commit();
		session.close();
		return insertCnt;
	}
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : user
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 활성화, 비활성화 수정
	 */
	@Override
	public int boardUpdate(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("board.boardUpdate",boardVo);
		session.commit();
		session.close();
		return updateCnt;
	}
	
	/**
	 * Method : getBoard
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : user
	 * 변경이력 :
	 * @param b_boardname
	 * @return
	 * Method 설명 : 게시판 정보 조회
	 */
	@Override
	public BoardVo getBoard(int b_no) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo boardVo = session.selectOne("board.getBoard",b_no);
		session.close();
		return boardVo;
	}
}