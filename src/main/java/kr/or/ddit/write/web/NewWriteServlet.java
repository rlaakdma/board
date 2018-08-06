package kr.or.ddit.write.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.files.model.FilesVo;
import kr.or.ddit.files.service.FilesService;
import kr.or.ddit.files.service.FilesServiceInf;
import kr.or.ddit.files.web.FileUtil;

import javax.servlet.annotation.MultipartConfig;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class NewWriteServlet
 */
@WebServlet("/newWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class NewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int b_no = Integer.parseInt(request.getParameter("b_no")); // 게시판 번호
		
		// 게시판 정보 조회		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardAllList = boardService.getBoard(b_no);	// 게시판 번호로 해당 게시글 모두 찾기
		
		// session 객체에 게시판 정보를 설정
		HttpSession session = request.getSession();
		session.setAttribute("boardAllList", boardAllList);
		
		request.getRequestDispatcher("/common/newWrite.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
		int id3 = studentVo.getId();
		System.out.println(id3);
		
		// 파라미터 확인
		int b_no = Integer.parseInt(request.getParameter("b_no")); // 게시판 번호
		int id = Integer.parseInt(request.getParameter("id")); // 학생 ID
		String w_title = request.getParameter("w_title"); // 게시글 제목
		String w_cnt = request.getParameter("smarteditor"); // 내용
		String w_name = request.getParameter("w_name"); // 게시글 작성자
		
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();
		WriteVo writeVo = new WriteVo(); // 게시글 vo 열기
		
		writeVo.setB_no(b_no);
		writeVo.setId(id);
		writeVo.setW_title(w_title);
		writeVo.setW_cnt(w_cnt);
		writeVo.setW_name(w_name); // 저장
		
		System.out.println(b_no);
		System.out.println(id);
		System.out.println(w_title);
		System.out.println(w_cnt);
		System.out.println(w_name);
		System.out.println(b_no); // 출력

		int cnt = writeService.newWrite(writeVo); // 새글 저장
		
		int dd= 0;
		
		dd = Integer.parseInt(request.getParameter("dd"));
		System.out.println("dd=="+dd);
		
		int w_no = writeService.getWriteCnt(); // 갯수
		System.out.println(w_no);
		
		Collection<Part> parts = request.getParts();
		
		if(cnt > 0){ // 새글등록이 완료되었으면
	
			System.out.println("새글등록 완료");
			
			FilesVo filesVo = new FilesVo(); // 파일 vo 열기
			FilesServiceInf filesService = new FilesService();
			int cnt2 = 0;
			
			for(Part part : parts){
				System.out.println("part.getName"+part.getName());
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
							System.out.println("fileInsert 성공");
						}else{
							System.out.println("fileInsert 실패");
						}
					}					
				}
			}
			
			List<FilesVo> addFilesList = filesService.addFileList(w_no);
		
			request.setAttribute("addFilesList", addFilesList);
			response.sendRedirect("/writeDetail?id=" + w_no);
			
		}else{
			System.out.println("새글등록 실패");
			response.sendRedirect("/common/boardList.jsp");
		}
	}
}