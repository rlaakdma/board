package kr.or.ddit.write.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class UpdateWriteServlet
 */
@WebServlet("/updateWrite")
public class UpdateWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 수정 이동(완료)
		
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("w_no"));
		String w_title = request.getParameter("w_title");
		String w_cnt = request.getParameter("w_cnt");
		
//		Part picPart = request.getPart("f_name"); // 프로필 사진
		
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = writeService.getWrite(w_no);
		
//		// files 정보를 조회
//		FilesServiceInf filesService = new FilesService();
//		FilesVo filesVo = new FilesVo();
//		
//		// 파라미터로 받은 값을 vo에 설정(저장하는 것)
//		writeVo.setW_title(w_title);
//		writeVo.setW_cnt(w_cnt);
//		
//		// 신규 이미지로 업데이트 하는 경우
//		if(picPart.getSize() > 0 ){
//			// 업로드 당시 파일명(pic)
//			// uuid를 통해 임의의 파일명을 하나 작성(picname)
//			// 업로드 할 경로(FileUtil.uploadPath)
//			
//			String contentDisposition = picPart.getHeader("Content-Disposition");			
//			String f_name = FileUtil.getFileName(contentDisposition);
//			String f_picpath = FileUtil.fileUploadPath;
//			String f_picname = UUID.randomUUID().toString();
//			
//			filesVo.setW_no(w_no);
//			filesVo.setF_picname(f_picname);
//			filesVo.setF_picpath(f_picpath);
//			filesVo.setF_name(f_name);
//			
//			picPart.write(f_picpath + File.separator + f_picname);
//			picPart.delete();
//		}
		
		// 게시글 정보 업데이트
//		writeService.writeUpdate(writeVo);
//		filesService.createFiles(filesVo);
		HttpSession session = request.getSession();
		session.setAttribute("writeVo", writeVo);
		
		// 게시글 정보 상세조회 화면으로 이동
		request.getRequestDispatcher("/common/updateWrite.jsp").forward(request, response);
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
