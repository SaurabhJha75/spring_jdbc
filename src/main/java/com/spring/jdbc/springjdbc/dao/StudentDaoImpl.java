package com.spring.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		//insert query
		 String query=" insert into student(id,name,city) values(?,?,?) ";
		 int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		 return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Student student) {
		//update query
		String query = " update student set name=?, city=? where id=?";
		int s = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return s;
	}

	public int delete(Student student) {
		//delete query
		String query = " delete from student where id=? ";
		int t = this.jdbcTemplate.update(query, student.getId());
		return t;
	}

	public Student getStudent(int studentId) {
		//select query
		String query = " select * from student where id=? ";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper, studentId );
		return student;
	}
	
	public List<Student> getAllStudents(){
		//selecting multiple student
		String query = " select * from student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}
	
	
}
