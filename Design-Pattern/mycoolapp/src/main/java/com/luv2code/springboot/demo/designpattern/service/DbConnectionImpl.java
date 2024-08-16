package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import com.luv2code.springboot.demo.designpattern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DbConnectionImpl implements DbConnectionService {
    private final StudentRepository studentRepository;

    @Autowired
    public DbConnectionImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

    }

}
