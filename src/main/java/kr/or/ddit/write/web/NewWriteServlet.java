package kr.or.ddit.write.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
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
import kr.or.ddit.file.FileUtil;
import kr.or.ddit.files.model.FilesVo;
import kr.or.ddit.files.service.FilesService;
import kr.or.ddit.files.service.FilesServiceInf;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class NewWriteServlet
 */
@WebServlet("/newWrite")
public class NewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		// 게시판 정보 조회		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardAllList = boardService.getBoard(b_no);	
		
		// session 객체에 게시판 정보를 설정
		HttpSession session = request.getSession();
		session.setAttribute("boardAllList", boardAllList);
		
		request.getRequestDispatcher("/common/newWrite.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 확인
		int b_no = Integer.parseInt(request.getParameter("b_no")); // 게시판 번호
		int id = Integer.parseInt(request.getParameter("id")); // 학생 ID
		String w_title = request.getParameter("w_title"); // 게시글 제목
		String w_cnt = request.getParameter("w_cnt"); // 내용
		String w_name = request.getParameter("w_name"); // 내용
		
//		Part picPart = request.getPart("f_name"); // 프로필 사진
		
		// service 게시글 정보를 조회
		WriteServiceInf writeService = new WriteService();		
		WriteVo writeVo = new WriteVo();
		
		writeVo.setB_no(b_no);
		writeVo.setId(id);
		writeVo.setW_title(w_title);
		writeVo.setW_cnt(w_cnt);
		writeVo.setW_name(w_name);

		writeService.newWrite(writeVo); // 새글 저장
		/*
		// files 정보를 조회
		FilesServiceInf filesService = new FilesService();
		FilesVo filesVo = new FilesVo();
		
		// 파라미터로 받은 값을 vo에 설정(저장하는 것)
		writeVo.setW_title(w_title);
		writeVo.setW_cnt(w_cnt);
		
		// 신규 이미지로 업데이트 하는 경우
		if(picPart.getSize() > 0 ){
			// 업로드 당시 파일명(pic)
			// uuid를 통해 임의의 파일명을 하나 작성(picname)
			// 업로드 할 경로(FileUtil.uploadPath)
			
			String contentDisposition = picPart.getHeader("Content-Disposition");			
			String f_name = FileUtil.getFileName(contentDisposition);
			String f_picpath = FileUtil.fileUploadPath;
			String f_picname = UUID.randomUUID().toString();
			
			filesVo.setW_no(w_no);
			filesVo.setF_picname(f_picname);
			filesVo.setF_picpath(f_picpath);
			filesVo.setF_name(f_name);
			
			picPart.write(f_picpath + File.separator + f_picname);
			picPart.delete();
		}
		*/
		
//		// 게시판 정보 조회		
//		BoardServiceInf boardService = new BoardService();
//		List<BoardVo> boardAllList = boardService.getAllboard();	
//		
//		// session 객체에 게시판 정보를 설정
//		HttpSession session = request.getSession();
//		session.setAttribute("boardAllList", boardAllList);
//		
//		request.getRequestDispatcher("/common/boardList.jsp").forward(request, response);	
	
//		filesService.createFiles(filesVo);s			
		
		// 게시글 정보 상세조회 화면으로 이동
//		response.sendRedirect("/writeDetail?id="+w_no);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("common/boardList.jsp");
//		rd.forward(request, response);
		
		int Cnt = writeService.getWriteCnt();
		
		HttpSession session = request.getSession();	
		session.setAttribute("writeVo", writeVo);
		// 게시글 정보 상세조회 화면으로 이동
		response.sendRedirect("/writeDetail?b_no="+b_no+"&id="+Cnt);
		// response : 
		// redirect : 클라이언트 최초요청 -> 클라이언트에게 다른 주소로 재 요청하라고 응답 -> 리다이렉트 정보를 바탕으로 재요청
	}
}