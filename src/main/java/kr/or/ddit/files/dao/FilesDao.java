package kr.or.ddit.files.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.files.model.FilesVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FilesDao implements FilesDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : createFiles
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param filesVo
	 * @return
	 * Method 설명 : 첨부파일을 추가한다.
	 */
	@Override
	public int createFiles(FilesVo filesVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("files.createFiles", filesVo);
		session.commit();
		session.close();
		return insertCnt;
	}	
	
	/**
	 * Method : addFileList
	 * 최초작성일 : 2018. 7. 30.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param w_no
	 * @return
	 * Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 첨부파일 리스트 반환
	 */
	@Override
	public List<FilesVo> addFileList(int w_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FilesVo> addfileList = session.selectList("files.addFileList", w_no);
		session.close();
		return addfileList;
	}
	
	/**
	 * Method : filesUpdate
	 * 최초작성일 : 2018. 7. 30.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param filesVo
	 * @return
	 * Method 설명 : 첨부파일을 수정한다
	 */
	@Override
	public int filesUpdate(FilesVo filesVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("files.boardUpdate",filesVo);
		session.commit();
		session.close();
		return updateCnt;
	}
}
