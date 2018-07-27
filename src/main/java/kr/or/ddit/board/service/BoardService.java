package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {

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
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getAllboard();
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
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getYboard();
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
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.createboard(boardVo);
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
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.boardUpdate(boardVo);
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
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getBoard(b_no);
	}
}