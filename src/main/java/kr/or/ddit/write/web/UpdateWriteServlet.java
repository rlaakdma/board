package kr.or.ddit.write.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.comments.model.CommentsVo;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceInf;
import kr.or.ddit.files.model.FilesVo;
import kr.or.ddit.files.service.FilesService;
import kr.or.ddit.files.service.FilesServiceInf;
import kr.or.ddit.files.web.FileUtil;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class UpdateWriteServlet
 */
@WebServlet("/updateWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class UpdateWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 수정 이동(완료)		
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("w_no"));
				
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = writeService.getWrite(w_no);
		
		FilesServiceInf addfilesService = new FilesService();
		List<FilesVo> FilesList = addfilesService.addFileList(w_no);
		
		HttpSession session = request.getSession();
		request.setAttribute("writeVo", writeVo);
		request.setAttribute("FilesList", FilesList);
		
		// 게시글 정보 상세조회 화면으로 이동
		request.getRequestDispatcher("/common/updateWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 수정(완료)		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		// 파라미터 확인
		int w_no = Integer.parseInt(request.getParameter("w_no"));
		String w_title = request.getParameter("w_title");
		String w_cnt = request.getParameter("smarteditor");
		
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
		
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = writeService.getWrite(w_no);
			
		writeVo.setW_no(w_no);
		writeVo.setW_title(w_title);
		writeVo.setW_cnt(w_cnt);
		
		int cnt = 0;
		
		cnt = writeService.writeUpdate(writeVo);
		
		int dd0 = Integer.parseInt(request.getParameter("dd0"));
		
		int dd = request.getParameter("dd") == null ? dd0 : Integer.parseInt(request.getParameter("dd"));	
		System.out.println("dd=="+dd);
		
		Collection<Part> parts = request.getParts();
		
		
//		w_no = writeService.getWriteCnt(); // 갯수
//		System.out.println(w_no);
		
		if(cnt > 0){ // 수정 완료되었으면	
			
			System.out.println("수정 완료");
			
			FilesVo filesVo = new FilesVo(); // 파일 vo 열기
			FilesServiceInf filesService = new FilesService();
			int cnt2 = 0;
			
			for(Part part : parts){
//				System.out.println("part.getName"+part.getName());
				if(part.getSize() > 0){
					String contentDisposition = part.getHeader("Content-Disposition");
				 	String f_name = FileUtil.getFileName(contentDisposition);
					if(!f_name.equals("")){ // 파일이름이 있다면						
						System.out.println("f_name : " + f_name);
						String f_picpath = FileUtil.fileUploadPath;
						System.out.println("f_picpath : " + f_picpath);
						String f_picname = UUID.randomUUID().toString();
						System.out.println("f_picname : " + f_picname);
						
						filesVo.setW_no(w_no); // 게시글 번호
						filesVo.setF_picname(f_picname); // 업로드파일명
						filesVo.setF_picpath(f_picpath); // 파일경로
						filesVo.setF_name(f_name); // 파일이름
						
						part.write(f_picpath + File.separator + f_name);
						part.delete();						
						
						cnt2 = filesService.createFiles(filesVo);
						
						if(cnt2 > 0){
							System.out.println("파일 수정 성공");
						}else{
							System.out.println("파일 수정 실패");
						}
					}					
				}
			}
			
			List<FilesVo> addFilesList = filesService.addFileList(w_no);
			
			CommentsServiceInf comService = new CommentsService();
			List<CommentsVo> comList = comService.getComments(w_no);
			
			request.setAttribute("w_no", w_no);
			request.setAttribute("addFilesList", addFilesList);
			request.setAttribute("comList", comList);
			response.sendRedirect("/writeDetail?id=" + w_no);
			
		}else{
			System.out.println("수정 실패");
			response.sendRedirect("/writeDetail.jsp="+w_no);
		}
	}
}