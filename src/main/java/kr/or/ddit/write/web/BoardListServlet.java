package kr.or.ddit.write.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class boardList
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("b_no", b_no);	
		
		// 게시판 페이지 리스트, 전체 건수조회
		WriteServiceInf writeService = new WriteService();
		List<WriteVo> writeAllList = writeService.getAllwrite();
		
		Map<String, Object> resultMap = writeService.getBoardPageList(map);
		
		// 게시판 페이지 리스트
		List<WriteVo> writeList = (List<WriteVo>) resultMap.get("pageList");
		
		HttpSession session = request.getSession();
		session.setAttribute("writeList",writeList);
		session.setAttribute("writeAllList", writeAllList);	
		session.setAttribute("b_no", b_no);
		
		// 페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi",pageNavi);
		
		BoardServiceInf boardService = new BoardService();		
		List<BoardVo> boardYList = boardService.getYboard();
		session.setAttribute("boardYList", boardYList);
		
		RequestDispatcher rd = request.getRequestDispatcher("common/boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}