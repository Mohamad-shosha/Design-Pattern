package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DbConnectionService {
    void save(StudentDto studentDto);

    void deleteById(Integer id);

    void update(Integer id, StudentDto studentDto);

    StudentDto getStudent(Integer id);

    Collection<StudentDto> getStudents();

    StudentDto getStudentInfo();
    void deleteByEmail(String email);
}
