package kr.or.ddit.file;

public class FileUtil {	
	
	// 파이 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";
	
	/**
	 * Method : getFileName 최초작성일 : 2018. 7. 16. 작성자 : PC18 변경이력 :
	 * 
	 * @param contentDisposition
	 * @return Method 설명 : part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	 * 
	 *         ex : form-data; name="uploadFile"; filename="moon.png" 
	 *         return : sally.png
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name="uploadFile"; filename="moon.png" --> contentDisposition 값
		String[] files = contentDisposition.split("; "); // split으로 ; 제거됨
		// form-data / name="uploadFile" / filename="moon.png"		
		
		String fileName = ""; // 초기값 생성
		// cookieStr = form-data, name="uploadFile", filename="moon.png"		
		
		for (String str : files) { // files 배열을 str로 for문 돌림
			// filename
			if (str.startsWith("filename")) { // filename 값이 있으면..
				fileName = str.substring("filename".length() + 2, str.length() - 1); // 앞 2글자, 뒷 1글자 제거?
				break;
			}
		}
		return fileName; // 반환
	}
}