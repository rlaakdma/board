package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {

	private BoardDaoInf boardDao;
	
	@Before
	public void setup(){
		boardDao = new BoardDao();
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
		List<BoardVo> boardList = boardDao.getAllboard();
		
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
		List<BoardVo> boardList = boardDao.getYboard();
		
		for(BoardVo vo : boardList)
			System.out.println(vo);

		/***Then***/
		assertEquals(1, boardList.size());
	}
	
//	@Test
//	public void creatboardTest(){
//		/***Given***/
//		BoardVo boardVo = new BoardVo();
//		boardVo.setB_no(b_no.nextval);
//		boardVo.setId(2);
//		boardVo.setB_boardname("테스트");
//		boardVo.setB_name("김마음");
//		boardVo.setB_date(sysdate);
//		boardVo.setB_use("y");
//
//		/***When***/
//		int insertCnt = boardDao.creatboard(boardVo);
//
//		/***Then***/
//		assertEquals(1,insertCnt);
//	}
}