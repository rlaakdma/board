package kr.or.ddit.comments.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comments.model.CommentsVo;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceInf;

/**
 * Servlet implementation class CntServlet
 */
@WebServlet("/insertCnt")
public class CntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 댓글 추가
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("w_no"));
		int id = Integer.parseInt(request.getParameter("id"));		
		String c_cnt = request.getParameter("c_cnt");
		String c_name = request.getParameter("c_name");
				
		// 댓글 정보 조회(service)
		CommentsServiceInf commentsService = new CommentsService();
		CommentsVo commentsVo = new CommentsVo();
		
		// 파라미터로 받은 값을 vo에 설정(저장하는 것)
		commentsVo.setW_no(w_no);
		commentsVo.setId(id);
		commentsVo.setC_cnt(c_cnt);
		commentsVo.setC_name(c_name);
		
		// 댓글 생성
		commentsService.createcomments(commentsVo);
		List<CommentsVo> commentsList = (List<CommentsVo>) commentsService.getComments(w_no);
	
		request.setAttribute("commentsList", commentsList);				
		
		request.getRequestDispatcher("/common/writeDetail.jsp?id="+w_no).forward(request, response);
		
		// 게시글 상세조회 화면으로 이동
//		response.sendRedirect("/writeDetail?id="+w_no);
		
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청		
	}
	
	// 댓글 삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}