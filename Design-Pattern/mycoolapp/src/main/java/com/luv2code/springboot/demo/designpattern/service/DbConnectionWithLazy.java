package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import com.luv2code.springboot.demo.designpattern.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbConnectionWithLazy implements DbConnectionService {

    // Lazy instantiation ....
    private static DbConnectionWithLazy instance;
    private static Repository repository;

    private DbConnectionWithLazy() {

    }

    @Autowired(required = false)
    public void setRepository(Repository repository) {
        DbConnectionWithLazy.repository = repository;
    }

    // Thread Safe ....
    public synchronized static DbConnectionWithLazy getInstance() {
        if (instance == null) {
            instance = new DbConnectionWithLazy();
        }
        return instance;
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