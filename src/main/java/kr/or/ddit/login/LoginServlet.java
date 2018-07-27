package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");		
		System.out.println(request.getMethod()); // POST		
		response.setContentType("text/html;charset=utf-8");	
		
		// 파라미터를 받아서 sysout으로 console 창에 출력
		String studentId = request.getParameter("studentId");
		String pass = request.getParameter("pass");
		
		// 로그인 프로세스
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(studentId);		
		
		// 게시판 생성 프로세스
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardYList = boardService.getYboard();
		
		if(studentVo.vaildateUser(studentId, pass)){
			System.out.println("접속 성공");
			HttpSession session = request.getSession();
			session.setAttribute("studentVo", studentVo);
			session.setAttribute("boardYList", boardYList);
			request.getRequestDispatcher("/common/main.jsp").forward(request, response); // RequestDispatcher 2안. <-- 기존 값. ("jsp/main.jsp")
			
		}else{
			System.out.println("접속 실패");
			//response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}

		System.out.println("ID : " + studentId + " / Password : " + pass);
	}
}