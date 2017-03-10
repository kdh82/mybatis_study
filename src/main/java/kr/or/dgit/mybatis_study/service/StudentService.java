package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {}
	
	public List<Student> selectStudentByAll(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class); //맵핑
//		sqlSession.close();
		return studentDao.selectStudentByAll();
	}
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class); //맵핑
		int res = studentDao.insertStudent(student);
		sqlSession.commit();    // commit해야 삽입됨
		return res;                   // res 0이면 안들어간거고 1이면 삽입된것 
	}
	
	public int insertStudentWithPhoe(Student student){
		int res = -1;
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class); //맵핑
			 res = studentDao.insertStudentWithPhoe(student);// 두개이상작업일때만 트렌젝션
			 sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
		
		
	}
	
	//selectStudentByNo
	public Student selectStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class); //맵핑
		return studentDao.selectStudentByNo(studNo);
	}
	public int updateStudent(Student student){
	SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
	StudentDao studentDao = sqlSession.getMapper(StudentDao.class); //맵핑
	int res = studentDao.insertStudent(student);
	sqlSession.commit();
	return res;
	}
	public int deleteStudent(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.deleteStudentByNo(studNo);
		sqlSession.commit();
		return res;
		
	}
}
