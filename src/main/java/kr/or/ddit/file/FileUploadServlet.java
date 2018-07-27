package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
// bytes
// 1kb = 1024
// 1mb = 1kb * 1000
// 5mb = 1mb * 5  == 1kb * 1000 * 5 = 1024 * 1000 * 5
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class FileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter : userId, uploadFile
		// 일반 텍스트 파라미터는 request.getParameter를 통해서 얻을 수 있다,
		// 파일의 경우 request.getPart를 통해서 얻을 수 있다.
		logger.debug("contentType : " + request.getContentType());
		logger.debug("userId : " + request.getParameter("userId")); // userId 값을 부른다.
		// logger.debug("uploadFile : " + request.getParameter("userIdFile"));
		
		// getPart
		Part uploadFilePart = request.getPart("uploadFile");
		//logger.debug("part getName : " + uploadFilePart.getName());
		
		// file 이름에 대한 정보를 획득 : getHeader("Content-Disposition");
		// form-data; name="uploadFile"; filename="moon.png"
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition : " + contentDisposition); // 전체 ...
		
		String fileName = FileUtil.getFileName(contentDisposition);
		logger.debug("filename : " + fileName); // contentDisposition를 쪼개서...
		
		// 파일 저장 경로 설정
		// 실무 : 별도 storage
		// 개발환경 : 임의 영역(서버 변경시, 재기동시 파일 삭제됨)
		// /fileUpload 디렉토리에 임의로 작성
		
		// D:\A_TeachingMaterial\7.JspSpring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
		
		// url --> realpath : application 객체에서 제공해주는 메서드
		// doPost 메소드 안에서 application(servletContext) 객체를 구한다.
		
		// 1. request.getServletContext()
		// 2. getServletContext() (서블릿에서 제공해주는 메소드)		
		
		// 임의의 배포경로
//		ServletContext servletContext = getServletContext();
//		String path = servletContext.getRealPath("/fileUpload");
		
		// 고정된 영역으로 배포
		String path = FileUtil.fileUploadPath;
		
		// http://localhost:8180/fileUpload/cony.png
		// filesize가 정상적인 경우에만 업로드를 수행한다.
		if(uploadFilePart.getSize() > 0){
			//uploadFilePart.write(path + File.separator + fileName);	// separator 알아서 바꿔줌.. 운영체제???
			// 사용자가 업로드한 실제 파일명은 디비상에 저장하고, 물리적 파일명은 임의로 적용
			uploadFilePart.write(path + File.separator + UUID.randomUUID().toString());
			uploadFilePart.delete();
		}		
	}
}