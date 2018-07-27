package kr.or.ddit.write.web;

import java.io.IOException;

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
 * Servlet implementation class ReplyWriteServlet
 */
@WebServlet("/replyWrite")
public class ReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 답글 이동
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		// 게시판 정보 조회		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardAllList = boardService.getBoard(b_no);	
		
		// session 객체에 게시판 정보를 설정
		HttpSession session = request.getSession();
		session.setAttribute("boardAllList", boardAllList);
		
		request.getRequestDispatcher("/common/newReply.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}