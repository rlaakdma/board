package kr.or.ddit.student.service;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {

	@Override
	public StudentVo getStudent(String std_id) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(std_id);
	}
}