package kr.or.ddit.files.web;

public class FileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";
	
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : java
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	* 
	* ex : form-data; name=\"uploadFile\"; filename=\"brown.png\"
	* return : brown.png
	*/
	public static String getFileName(String contentDisposition){
		String[] fileNames = contentDisposition.split("; ");
		String fileNameResult = "";
		
		for(String fileNameStr : fileNames){
//			String[] fileNameValue = fileNameStr.split("\"");
//			
//			String fileName = fileNameValue[0]; 
//			
//			if(fileName.equals("filename=")){
//				fileNameResult = fileNameValue[1];
//				break;
//			}
			
			//filename : filename=\"brown.png\"
			//answer : brown.png
			if(fileNameStr.startsWith("filename")){
				fileNameResult = fileNameStr.substring("filename".length()+2, fileNameStr.length()-1);
				break;
			}
		}			
		return fileNameResult;
	}
}
