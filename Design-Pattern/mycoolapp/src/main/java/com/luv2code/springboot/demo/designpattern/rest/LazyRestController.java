package com.luv2code.springboot.demo.designpattern.rest;
import com.luv2code.springboot.demo.designpattern.entity.Student;
import com.luv2code.springboot.demo.designpattern.lazyinstantiation.DbConnectionWithLazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("Lazy")
public class LazyRestController {

    @GetMapping("/AddStudent")
    public void addStudent(){
        DbConnectionWithLazy dbConnectionWithLazy =DbConnectionWithLazy.getInstance();
        Student student = new Student(3,"Karim",27);
        dbConnectionWithLazy.save(student);
    }
    @GetMapping("/AddStudents")
    public void addStudents (){
        DbConnectionWithLazy dbConnectionWithLazy =DbConnectionWithLazy.getInstance();
        Student [] student = {new Student(1,"mohamed",20),new Student(5,"Ahmed",40),new Student(3,"shosha",30)};
        Set<Student> students = new HashSet<>(Arrays.asList(student));
        dbConnectionWithLazy.addAll(students);
    }
    @GetMapping("/GetStudents")
    public Set<Student> getStudents (){
        return DbConnectionWithLazy.getInstance().getStudents();
    }

    @GetMapping("/GetStudent")
    public Student getStudent () {
        return DbConnectionWithLazy.getInstance().getStudent(5);
    }

    @GetMapping("/UpdateStudent")
    public void updateStudent (){
        Student student = new Student(4,"Ebrahim",67);
        DbConnectionWithLazy.getInstance().update(1,student);
    }

    @GetMapping("/DeleteStudent")
    public void deleteStudent (){
        DbConnectionWithLazy.getInstance().delete(4);
    }


}