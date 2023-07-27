package com.jsp.school.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.school.dto.Student;
import com.jsp.school.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/studentload")
	public ModelAndView studentLoad() {
		ModelAndView modelAndView = new ModelAndView("studentform.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;

	}

	@RequestMapping("/studentadd")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		Student s = studentService.saveStudent(student);
		modelAndView.addObject("saved", s.getName() + " saved successfully");
		return modelAndView;
	}

	@RequestMapping("/viewAllStudent")
	public ModelAndView viewAllStudent() {
		ModelAndView modelAndView = new ModelAndView("ViewAll.jsp");
		List<Student> students = studentService.viewAllStudents();
		modelAndView.addObject("students", students);
		return modelAndView;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name = "id") int id) {
		boolean b = studentService.deleteStudentById(id);
		ModelAndView modelAndView = new ModelAndView("ViewAll.jsp");

		if (b == true) {
			List<Student> students = studentService.viewAllStudents();
			modelAndView.addObject("students", students);
		}
		return modelAndView;
	}

	@GetMapping("/update")
	public ModelAndView updateStudent(@RequestParam(name = "id") int i) {
		Student existingStudent = studentService.getStudentById(i);
		ModelAndView modelAndView = new ModelAndView("update.jsp");
		modelAndView.addObject("student2", existingStudent);
		return modelAndView;
	}

	@RequestMapping("/updateStudent")
	public ModelAndView updateStudentById(@ModelAttribute Student student) {
		int id = student.getId();
		Student s = studentService.updateStudentById(id, student);
		ModelAndView modelAndView = new ModelAndView("ViewAll.jsp");
		List<Student> students = studentService.viewAllStudents();
		modelAndView.addObject("students", students);
		return modelAndView;
	}
}
