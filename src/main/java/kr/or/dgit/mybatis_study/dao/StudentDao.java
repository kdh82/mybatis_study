package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {
	int insertStudent(Student student);
	List<Student> selectStudentByAll(); // 파라미터없고 스튜던트를 리스트로 받아서 던짐
	//과제 테스트까지 완료 branch이용해서
	Student selectStudentByNo(int studNo);
//	int updateStduent(Student student);
//	int deleteStudentByNo(int studNo);
}
