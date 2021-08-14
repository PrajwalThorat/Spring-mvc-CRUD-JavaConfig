package org.stackroute.StuDao;

import java.util.List;

import org.stackroute.model.Student;

public interface StudentDao {
	
	//CRUD operation --
	
	public boolean addStudent(Student student);
	public boolean deleteStudent(String email);
	public List<Student> allStudent();
	public boolean updateStudent(Student student);
	public Student getByEmail(String email);
	

}
