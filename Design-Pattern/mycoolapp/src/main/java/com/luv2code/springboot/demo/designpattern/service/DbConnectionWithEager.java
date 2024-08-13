package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import com.luv2code.springboot.demo.designpattern.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbConnectionWithEager implements DbConnectionService {

    // Eager instantiation
    private static final DbConnectionWithEager instance = new DbConnectionWithEager();
    private static Repository repository;

    private DbConnectionWithEager() {

    }

    @Autowired(required = false) // Setter injection
    public void setRepository(Repository repository) {
        DbConnectionWithEager.repository = repository;
    }

    public static DbConnectionWithEager getInstance() {
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