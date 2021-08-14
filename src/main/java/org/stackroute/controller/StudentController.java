package org.stackroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.stackroute.StuDao.StudentDao;
import org.stackroute.model.Student;

@Controller
public class StudentController {
	
	private StudentDao studentDao;
	
	public StudentController(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@GetMapping("/")
	public ModelAndView pageView() {
		return new ModelAndView("index" , "studentList" , studentDao.allStudent());
	}
	
	// create user
	@PostMapping("/addStudent")
	public String addStudent(@RequestParam("id") Integer id , @RequestParam("name")String name , @RequestParam("email") String email) {
		Student exitStudent = studentDao.getByEmail(email);
		if(exitStudent != null) {
			exitStudent.setId(id);
			exitStudent.setName(name);
			studentDao.updateStudent(exitStudent);
		}else {
			studentDao.addStudent(new Student(id, name,email));
		}
		return "redirect:/";
	}
	
	//Delete user 
	@GetMapping("/deleteStudent/{email}")
	public String deleteStudent(@PathVariable String email) {
		studentDao.deleteStudent(email);
		return "redirect:/";
	}
	
	@GetMapping("/updateStudent/{email}")
	public String updateStudent(@PathVariable String email, ModelMap modelMap) {
		Student studentData = studentDao.getByEmail(email);
		modelMap.addAttribute("studentdata", studentData);
		modelMap.addAttribute("studentList", studentDao.allStudent());
		return "index";
		
	}
}
