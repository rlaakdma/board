package kr.or.ddit.student.dao;

import kr.or.ddit.student.model.StudentVo;

public interface StudentDaoInf {
	
	StudentVo getStudent(String std_id);

}