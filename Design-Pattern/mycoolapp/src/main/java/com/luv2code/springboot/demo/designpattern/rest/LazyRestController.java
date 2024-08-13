package com.luv2code.springboot.demo.designpattern.rest;
import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import com.luv2code.springboot.demo.designpattern.service.DbConnectionWithLazy;
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

    @GetMapping("/GetStudents")
    public Collection<Student> getStudents (){
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