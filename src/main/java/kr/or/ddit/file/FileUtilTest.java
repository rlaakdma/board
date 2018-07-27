package kr.or.ddit.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileUtilTest { // 테스트

//	/**
//	 * Method : getFileNametest
//	 * 최초작성일 : 2018. 7. 16.
//	 * 작성자 : PC18
//	 * 변경이력 :
//	 * Method 설명 : 전체 값에 대한 분리 작업 확인
//	 */
//	@Test
//	public void getFileNametest() {
//		/***Given***/
//		String[] files = "form-data; name=\"uploadFile\"; filename=\"moon.png\"".split("; ");
//
//		/***When***/
//
//		/***Then***/
//		assertEquals(3, files.length);
//		assertEquals("form-data", files[0]);
//		assertEquals("name=\"uploadFile\"", files[1]);
//		assertEquals("filename=\"moon.png\"", files[2]);
//	}
//	
//	@Test
//	public void fileNameValueSplitTest(){
//		/***Given***/
//		String file = "name=\"uploadFile\"";
//
//		/***When***/
//		// fileArr[0] = name
//		// fileArr[1] = "uploadFile"
//		String[] fileArr = file.split("=");
//
//		/***Then***/
//		assertEquals("name", fileArr[0]);
//		assertEquals("\"uploadFile\"", fileArr[1]);		
//	}
//	
//	@Test
//	public void getFileTest(){ // X
//		/***Given***/
//		FileUtil fileUtil = new FileUtil();
//
//		/***When***/
//		// name ==> "uploadFile"
//		String fileValue = fileUtil.getFileName("form-data=\"\"; name=\"uploadFile\"; filename=\"moon.png\"");
//		
//		/***Then***/
//		assertEquals("moon.png", fileValue);
//	}
}