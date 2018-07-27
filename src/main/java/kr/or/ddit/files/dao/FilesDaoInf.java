package kr.or.ddit.files.dao;

import kr.or.ddit.files.model.FilesVo;

public interface FilesDaoInf {
	
	/**
	 * Method : createFiles
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param filesVo
	 * @return
	 * Method 설명 : 첨부파일을 추가한다.
	 */
	int createFiles(FilesVo filesVo);
}
