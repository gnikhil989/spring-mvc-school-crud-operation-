package com.jsp.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.school.dao.StudentDao;
import com.jsp.school.dto.Student;

@Component
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public Student saveStudent (Student student) {
		return studentDao.saveStudent(student);
	}
	public List<Student> viewAllStudents(){
		return studentDao.viewAllStudents();
	}
public boolean deleteStudentById(int id) {
	return studentDao.deleteStudentById(id);
	
}
public Student updateStudentById(int id, Student student) {
	return studentDao.updateStudentById(id, student);
	
}
public Student getStudentById(int id) {
	return studentDao.getStudentById(id);
}
}
