package kr.or.ddit.write.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.write.model.WriteVo;

public class WriteDao implements WriteDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : user
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 각 게시판 페이징 기법
	 */
	@Override
	public List<WriteVo> getBoardPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<WriteVo> writeList = session.selectList("write.getBoardPageList",map);
		session.close();
		return writeList;
	}
	
	/**
	 * Method : getWriteTotCnt
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	@Override
	public int getWriteTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("write.getWriteTotCnt");
		session.close();
		return cnt;
	}

	/**
	 * Method : getWrite
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 게시글 상세 조회
	 */
	@Override
	public WriteVo getWrite(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		WriteVo writeVo = session.selectOne("write.getWrite",id);
		session.close();
		return writeVo;
	}
	
	/**
	 * Method : writeUpdate
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	@Override
	public int writeUpdate(WriteVo writeVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("write.writeUpdate", writeVo);
		session.commit();
		session.close();
		return updateCnt;
	}
	
	/**
	 * Method : writeUpdate
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	@Override
	public int writeDelete(WriteVo writeVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("write.writeDelete", writeVo);
		session.commit();
		session.close();
		return updateCnt;
	}
	
	/**
	 * Method : getAllwrite
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글을 조회한다.
	 */
	@Override
	public List<WriteVo> getAllwrite() {
		SqlSession session = sqlSessionFactory.openSession();
		List<WriteVo> writeList = session.selectList("write.getAllwrite");
		session.close();
		
		return writeList;
	}
	
	/**
	 * Method : newWrite
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 게시글(새글등록)을 작성한다(파일첨부는 Files테이블에 작성함).
	 */
	@Override
	public int newWrite(WriteVo writeVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("write.newWrite", writeVo);
		session.commit();
		session.close();
		return insertCnt;
	}
	
	/**
	 * Method : newWrite
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	@Override
	public int getWriteCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("write.getWriteCnt");
		session.close();
		return cnt;
	}
}