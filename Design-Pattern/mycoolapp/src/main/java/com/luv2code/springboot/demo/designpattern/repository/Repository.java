package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Repository {
    private final Student student;
    private final Map<Integer, Student> studentMap;

    @Autowired
    public Repository(Student student) {
        this.student = student;
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void updateStudent(Integer id, Student updatedStudent) {
        if (studentMap.containsKey(id)) {
            studentMap.put(id, updatedStudent);
        }
    }

    public void deleteStudent(Integer id) {
        studentMap.remove(id);
    }

    public Collection<Student> findAll() {
        return studentMap.values();
    }

    public Student findStudentById(Integer id) {
        return studentMap.get(id);
    }
    public Student getStudentInfo (){
        return student;
    }
}