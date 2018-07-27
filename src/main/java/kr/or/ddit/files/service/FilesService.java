package kr.or.ddit.files.service;

import kr.or.ddit.files.dao.FilesDao;
import kr.or.ddit.files.dao.FilesDaoInf;
import kr.or.ddit.files.model.FilesVo;

public class FilesService implements FilesServiceInf {
	
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
	public int createFiles(FilesVo filesVo){
		FilesDaoInf filesDao = new FilesDao();
		return filesDao.createFiles(filesVo);
	}
}
