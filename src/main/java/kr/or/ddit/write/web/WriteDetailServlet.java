package kr.or.ddit.write.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceInf;
import kr.or.ddit.files.model.FilesVo;
import kr.or.ddit.files.service.FilesService;
import kr.or.ddit.files.service.FilesServiceInf;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteDetailServlet
 */
@WebServlet("/writeDetail")
public class WriteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  id를 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("id"));
		
		// service 학생 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = writeService.getWrite(w_no);
		
		FilesServiceInf addfilesService = new FilesService();
		List<FilesVo> addFileList = addfilesService.addFileList(w_no);
		
		CommentsServiceInf commentsService = new CommentsService();
		
		HttpSession session = request.getSession();
		
		// request 객체에 저장
		request.setAttribute("writeVo", writeVo);
		request.setAttribute("commentsList",commentsService.getComments(w_no));
		request.setAttribute("addFileList", addFileList);
		
		// student/studentDetail.jsp로 위임
		request.getRequestDispatcher("/common/writeDetail.jsp").forward(request, response);		
	}
}