package kr.or.ddit.write.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.write.model.WriteVo;

public interface WriteDaoInf {
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : user
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 각 게시판 페이징 기법
	 */
	List<WriteVo> getBoardPageList(Map<String, Integer> map);
	
	/**
	 * Method : getWriteTotCnt
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	int getWriteTotCnt();
	
	/**
	 * Method : getWrite
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 게시글 상세조회
	 */
	WriteVo getWrite(int id);
	
	/**
	 * Method : writeUpdate
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	int writeUpdate(WriteVo writeVo);
	
	/**
	 * Method : writeUpdate
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */	
	int writeDelete(WriteVo writeVo);
	
	/**
	 * Method : getAllwrite
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시판을 조회한다.
	 */
	List<WriteVo> getAllwrite();
	
	/**
	 * Method : newWrite
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글(새글등록)을 작성한다(파일첨부는 Files테이블에 작성함).
	 */	
	int newWrite(WriteVo writeVo);
	
	/**
	 * Method : newWrite
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */	
	int getWriteCnt();
}