package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.PhoneNumber;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

public class StudentDaoTest {
	private static StudentService studentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testselectStudentByAll() {
		List<Student> lists = studentService.selectStudentByAll();
		for(Student s : lists){
			System.out.println(s);
		}
		
		Assert.assertNotNull(lists);
	}
	/*@Test
	public void testinsertStudent() {
		Student std = new Student(6, "조시은", "jsw@test.co.kr", new Date());
		int res = studentService.insertStudent(std);
		
		Assert.assertEquals(1, res);
	}*/
	@Test
	public void testInsertStudentWithPhone(){
		Student std = new Student(7, "이교민", "jsw@test.co.kr", new Date(), new PhoneNumber("010-2222-2222"));
		int res = studentService.insertStudentWithPhoe(std);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void testselectStudentByNo() {
		Student student = studentService.selectStudentByNo(5);
		Assert.assertNotNull(student);
	}

}
