package com.luv2code.springboot.demo.designpattern.lazyinstantiation;

import com.luv2code.springboot.demo.designpattern.entity.Student;
import com.luv2code.springboot.demo.designpattern.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbConnectionWithLazy {

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
        repository.saveStudent(student);
    }

    public void addAll(List<Student> students) {
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

    public List<Student> getStudents() {
        return repository.findAll();
    }
}