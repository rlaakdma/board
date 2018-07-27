package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {
	
	public BoardServiceInf boardService;
	
	@Before
	public void setup(){
		boardService = new BoardService();
	}
	
	/**
	 * Method : getAllboardTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * Method 설명 : 전체 게시판을 조회한다.
	 */
	@Test
	public void getAllboardTest() {
		/***Given***/
		/***When***/
		List<BoardVo> boardList = boardService.getAllboard();
		
		for(BoardVo vo : boardList)
			System.out.println(vo);

		/***Then***/
		assertEquals(2, boardList.size());
	}
	
	/**
	 * Method : getYboardTest
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC18
	 * 변경이력 :
	 * Method 설명 : 활성화 게시판을 조회한다.
	 */
	@Test
	public void getYboardTest() {
		/***Given***/
		/***When***/
		List<BoardVo> boardList = boardService.getYboard();
		
		for(BoardVo vo : boardList)
			System.out.println(vo);

		/***Then***/
		assertEquals(1, boardList.size());
	}
}