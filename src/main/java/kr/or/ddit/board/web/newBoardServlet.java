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
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class newBoard
 */
@WebServlet("/newBoard")
public class newBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시판 정보 조회		
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardAllList = boardService.getAllboard();	
		
		// session 객체에 게시판 정보를 설정
		HttpSession session = request.getSession();
		session.setAttribute("boardAllList", boardAllList);	
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
		int id3 = studentVo.getId();
		System.out.println(id3);
		
		// 위임
		request.getRequestDispatcher("/common/newBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}