package kr.or.ddit.write.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.write.dao.WriteDao;
import kr.or.ddit.write.dao.WriteDaoInf;
import kr.or.ddit.write.model.WriteVo;

public class WriteService implements WriteServiceInf {
	
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
	public Map<String, Object> getBoardPageList(Map<String, Integer> map) {
		WriteDaoInf writeDao = new WriteDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 게시판 페이지 리스트 조회
		List<WriteVo> pageList = writeDao.getBoardPageList(map);
		resultMap.put("pageList", pageList);
		
		// 게시글 전체 건수 조회
		int totCnt = writeDao.getWriteTotCnt();
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt){
		
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지
		
		if (mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/boardList?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i = 1; i <= cnt; i++){
			///boardList?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/boardList?page=" + i +
								"&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/boardList?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

	@Override
	public WriteVo getWrite(int id) {
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.getWrite(id);
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
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.writeUpdate(writeVo);
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
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.writeDelete(writeVo);
	}
	
	/**
	 * Method : getAllwrite
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시판을 조회한다.
	 */
	@Override
	public List<WriteVo> getAllwrite() {
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.getAllwrite();
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
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.newWrite(writeVo);
	}
	
	/**
	 * Method : answerWrite
	 * 최초작성일 : 2018. 7. 31.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param writeVo
	 * @return
	 * Method 설명 : 답글을 작성한다.
	 */
	@Override	
	public int answerWrite(WriteVo writeVo) {
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.answerWrite(writeVo);		
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
		WriteDaoInf writeDao = new WriteDao();
		return writeDao.getWriteCnt();
	}
}