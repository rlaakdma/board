package kr.or.ddit.files.service;

import java.util.List;

import kr.or.ddit.files.model.FilesVo;

public interface FilesServiceInf {
	
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
	
	/**
	 * Method : addFileList
	 * 최초작성일 : 2018. 7. 30.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param w_no
	 * @return
	 * Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 첨부파일 리스트 반환
	 */	
	List<FilesVo> addFileList(int w_no);
	
	/**
	 * Method : filesUpdate
	 * 최초작성일 : 2018. 7. 30.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param filesVo
	 * @return
	 * Method 설명 : 첨부파일을 수정한다
	 */	
	int filesUpdate(FilesVo filesVo);
}
