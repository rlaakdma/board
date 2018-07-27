package kr.or.ddit.write.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class UpdateWriteServlet
 */
@WebServlet("/deleteWrite")
public class DeleteWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 삭제(완료)
		
		// 게시글 번호를 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("w_no"));
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String w_dlt = request.getParameter("w_dlt");
		
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = writeService.getWrite(w_no);
		
		writeVo.setW_dlt(w_dlt);
		
		// 게시글 정보 업데이트
		writeService.writeDelete(writeVo);
		
		// request 객체에 저장
		request.setAttribute("writeVo", writeVo);
		
		// 게시글 정보 상세조회 화면으로 이동
		response.sendRedirect("/boardList?b_no="+b_no+"&page=1&pageSize=10");
		
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}