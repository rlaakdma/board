package kr.or.ddit.comments.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceInf;

/**
 * Servlet implementation class DeleteCnt
 */
@WebServlet("/deleteCnt")
public class DeleteCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 삭제
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		int w_no = Integer.parseInt(request.getParameter("w_no"));
		
		CommentsServiceInf comService = new CommentsService();
		int cnt = comService.updateCnt(c_no);
		
		if(cnt > 0){
			System.out.println("댓글 삭제 성공");
		}else{
			System.out.println("댓글 삭제 실패");
		}
		
		response.sendRedirect("/writeDetail?id="+w_no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}