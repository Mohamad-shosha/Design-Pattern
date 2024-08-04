package com.luv2code.springboot.demo.designpattern.rest;
import com.luv2code.springboot.demo.designpattern.eagerinstantiation.DbConnectionWithEager;
import com.luv2code.springboot.demo.designpattern.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("Eager")
public class EagerRestController {


  @GetMapping("/AddStudent")
  public void addStudent(){
    Student student = new Student(3,"Karim",27);
    DbConnectionWithEager.getInstance().save(student);
  }
  @GetMapping("/AddStudents")
  public void addStudents (){
    DbConnectionWithEager dbConnectionWithEager = DbConnectionWithEager.getInstance();
    Student [] student = {new Student(1,"mohamed",20),new Student(5,"Ahmed",40),new Student(3,"shosha",30)};
    List<Student> students = new ArrayList<>(Arrays.asList(student));
    dbConnectionWithEager.addAll(students);
  }
  @GetMapping("/GetStudents")
  public List<Student> getStudents (){
    return DbConnectionWithEager.getInstance().getStudents();
  }

  @GetMapping("/GetStudent")
  public Student getStudent () {
    return DbConnectionWithEager.getInstance().getStudent(5);
  }

  @GetMapping("/UpdateStudent")
  public void updateStudent (){
    DbConnectionWithEager dbConnectionWithEager = DbConnectionWithEager.getInstance();
    Student student = new Student(4,"Ebrahim",67);
    DbConnectionWithEager.getInstance().update(1,student);
  }

  @GetMapping("/DeleteStudent")
  public void deleteStudent (){
    DbConnectionWithEager.getInstance().delete(4);
  }

}