package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import java.util.Collection;

public interface StudentRepos{
    void addStudent(StudentDto studentDto);
    void updateStudent(Integer id, StudentDto updatedStudentDto);
    void deleteStudent(Integer id);
    Collection<StudentDto> findAll();
    StudentDto findStudentById(Integer id);
    StudentDto getStudentInfo();
    void deleteByEmail(String email);
}
