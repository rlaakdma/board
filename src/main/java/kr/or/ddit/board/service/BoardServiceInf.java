package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {
	
	/**
	 * Method : getAllboard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시판을 조회한다.
	 */
	List<BoardVo> getAllboard();
	
	/**
	 * Method : getYboard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 활성화 게시판을 조회한다.
	 */
	List<BoardVo> getYboard();
	
	/**
	 * Method : createboard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 활성화 혹은 비활성화 게시판을 생성한다.
	 */
	int createboard(BoardVo boardVo);
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : user
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 활성화, 비활성화 수정
	 */
	int boardUpdate(BoardVo boardVo);
	
	/**
	 * Method : getBoard
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : user
	 * 변경이력 :
	 * @param b_boardname
	 * @return
	 * Method 설명 : 게시판 정보 조회
	 */
	BoardVo getBoard(int b_no);
}