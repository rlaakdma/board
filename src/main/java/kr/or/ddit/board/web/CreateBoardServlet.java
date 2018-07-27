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
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int id = Integer.parseInt(request.getParameter("id1"));
		String boardname = request.getParameter("b_boardname1");
		String name = request.getParameter("b_name");
		String use = request.getParameter("b_use1");
		System.out.println(id);
		System.out.println(boardname);
		System.out.println(name);
		System.out.println(use);
		// 게시판 정보 조회(service)
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = new BoardVo();
		
		// 파라미터로 받은 값을 vo에 설정(저장하는 것)
		boardVo.setId(id);
		boardVo.setB_boardname(boardname);
		boardVo.setB_name(name);
		boardVo.setB_use(use);		
		
		// 게시판 생성
		boardService.createboard(boardVo);
		
		HttpSession session = request.getSession();
		
		List<BoardVo> boardYList = boardService.getYboard();
		session.setAttribute("boardYList", boardYList);
		
		List<BoardVo> boardAllList = boardService.getAllboard();		
		request.setAttribute("boardAllList", boardAllList);
		
		// 게시판 상세조회 화면으로 이동
		response.sendRedirect("/newBoard");
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청
	}
}