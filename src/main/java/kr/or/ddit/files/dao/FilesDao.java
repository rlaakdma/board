package kr.or.ddit.files.dao;

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
		int insertCnt = session.insert("files.createboard", filesVo);
		session.commit();
		session.close();
		return insertCnt;
	}
}
