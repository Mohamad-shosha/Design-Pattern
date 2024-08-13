package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DbConnectionService {
    void save(Student student);

    void delete(Integer id);

    void update(Integer id, Student student);

    Student getStudent(Integer id);

    Collection<Student> getStudents();

    Student getStudentInfo();
}
