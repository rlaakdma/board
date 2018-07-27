package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		String b_use = request.getParameter("b_use2");
		String b_boardname = request.getParameter("b_boardname2");
		int b_no = Integer.parseInt(request.getParameter("b_no"));		
		
		// 게시판 정보 조회(service)
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoard(b_no);
		
		// 파라미터로 받은 값을 vo에 설정(저장하는 것)
		boardVo.setB_use(b_use);
		boardVo.setB_boardname(b_boardname);
		boardVo.setB_no(b_no);		
		
		// 게시판 업데이트
		boardService.boardUpdate(boardVo);

		HttpSession session = request.getSession();
		
		List<BoardVo> boardYList = boardService.getYboard();
		session.setAttribute("boardYList", boardYList);
		
		List<BoardVo> boardAllList = boardService.getAllboard();		
		request.setAttribute("boardAllList", boardAllList);
		
		// 게시판 생성화면으로 이동
		response.sendRedirect("/newBoard");
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청		
	}
}