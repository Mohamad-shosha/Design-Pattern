package com.luv2code.springboot.demo.designpattern.eagerinstantiation;

import com.luv2code.springboot.demo.designpattern.entity.Student;
import com.luv2code.springboot.demo.designpattern.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DbConnectionWithEager {

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
        repository.saveStudent(student);
    }

    public void addAll(Set<Student> students) {
        repository.saveStudents(students);
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

    public Set<Student> getStudents() {
        return repository.findAll();
    }
}