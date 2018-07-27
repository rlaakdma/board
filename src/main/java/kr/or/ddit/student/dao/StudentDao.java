package kr.or.ddit.student.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override	
	public StudentVo getStudent(String std_id){
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudent",std_id);
		session.close();
		return studentVo;
	}
}
