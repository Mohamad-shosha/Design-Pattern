package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import com.luv2code.springboot.demo.designpattern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Primary
public class DbConnectionWithLazyImpl implements DbConnectionService {

    // Lazy instantiation ....
    private static DbConnectionWithLazyImpl instance;
    private static StudentRepository studentRepository;

    private DbConnectionWithLazyImpl() {
    }

    @Autowired(required = false)
    public void setRepository(StudentRepository studentRepository) {
        DbConnectionWithLazyImpl.studentRepository = studentRepository;
    }

    // Thread Safe ....
    public synchronized DbConnectionWithLazyImpl getInstance() {
        if (instance == null) {
            instance = new DbConnectionWithLazyImpl();
        }
        return instance;
    }

    public void save(StudentDto studentDto) {
        studentRepository.addStudent(studentDto);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteStudent(id);
    }

    public void update(Integer id, StudentDto studentDto) {
        studentRepository.updateStudent(id, studentDto);
    }

    public StudentDto getStudent(Integer id) {
        return studentRepository.findStudentById(id);
    }

    public Collection<StudentDto> getStudents() {
        return studentRepository.findAll();
    }

    public StudentDto getStudentInfo() {
        return studentRepository.getStudentInfo();
    }

    public void deleteByEmail(String email) {
        studentRepository.deleteByEmail(email);
    }
}
