package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.springjdbc.dao.StudentDao;
import com.spring.jdbc.springjdbc.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started...." );
        
        //spring jdbc => JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(Config_jdbc.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        	// Delete Query
       /* Student student = new Student();
        student.setId(104);
        		int result = studentDao.delete(student);
        		System.out.println("DEleted Successfully"); */
        
        	// Update Query
        /* Student student = new Student();
         student.setId(104);
         student.setName("Jyoti SIngh");
         student.setCity("Kolkata");
         
         	int result = studentDao.update(student);
         	System.out.println("Student Successfully Updated"); */
        
        	// Insert Query
        Student student = new Student();
       student.setId(113);
       student.setName("Swetha R");
       student.setCity("Banglore");
       
       int result = studentDao.insert(student);
       System.out.println("Student Successfully Added "); 
        
        //Student student = studentDao.getStudent(103);
        //System.out.println(student);
        
        List<Student> students = studentDao.getAllStudents();
        for(Student s : students) {
        	System.out.println(s);
        }
    }
}
