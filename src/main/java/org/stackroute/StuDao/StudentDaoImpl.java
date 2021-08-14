package org.stackroute.StuDao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.stackroute.model.Student;


@Component
public class StudentDaoImpl implements StudentDao {

	private List<Student> list;

	public boolean addStudent(Student student) {
		return list.add(student);
	}

	public boolean deleteStudent(String email) {
		Student existStudent = getByEmail(email);
		if (existStudent != null) {
			list.remove(existStudent);
			return true;
		}
		return false;
	}

	public List<Student> allStudent() {
		return list;
	}

	public boolean updateStudent(Student student) {
		Student existStudent = getByEmail(student.getEmail());
		if(existStudent!=null) {
			existStudent.setId(student.getId());
			existStudent.setName(student.getName());
			return true;
		}
		return false;
	}

	public Student getByEmail(String email) {
		Student student = null;
		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			student = itr.next();
			if (email.equals(student.getEmail())) {
				return student;
			}
		}
		return null;

//		boolean flag = false ;
//		for(int i=0 ; i< list.size() ; i++) {
//			if(list.get(i).getEmail().equals(email));
//			flag = true;
//		}
	}

}
