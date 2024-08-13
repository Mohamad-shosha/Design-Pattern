package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import com.luv2code.springboot.demo.designpattern.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Primary
public class DbConnectionImpl implements DbConnectionService {
    private final Repository repository;

    @Autowired
    public DbConnectionImpl(Repository repository) {
        this.repository = repository;
    }

    public void save(Student student) {
        repository.addStudent(student);
    }

    public void delete(Integer id) {
        repository.deleteStudent(id);
    }

    public void update(Integer id, Student student) {
        repository.updateStudent(id, student);
    }

    public Student getStudent(Integer id) {
        return repository.findStudentById(id);
    }

    public Collection<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentInfo() {
        return repository.getStudentInfo();
    }

}
