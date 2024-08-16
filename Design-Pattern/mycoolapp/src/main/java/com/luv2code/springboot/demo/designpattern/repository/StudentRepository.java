package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class StudentRepository implements StudentRepos {
    private final StudentDto studentDto;
    private final Map<Integer, StudentDto> studentMap;

    @Autowired
    public StudentRepository(StudentDto studentDto) {
        this.studentDto = studentDto;
        studentMap = new HashMap<>();
    }

    public void addStudent(StudentDto studentDto) {
        studentMap.put(studentDto.getId(), studentDto);
    }

    public void deleteStudent(Integer id) {
        studentMap.remove(id);
    }

    public Collection<StudentDto> findAll() {
        return studentMap.values();
    }

    public StudentDto findStudentById(Integer id) {
        return studentMap.get(id);
    }

    public StudentDto getStudentInfo() {
        return studentDto;
    }

    public void updateStudent(Integer id, StudentDto updatedStudentDto) {
        if (!studentMap.containsKey(id)) {
            log.error("Not found id of the student");
        } else {
            if (!updatedStudentDto.getId().equals(id)) {
                StudentDto studentDto = studentMap.values()
                        .stream()
                        .filter(element -> element.getId().equals(id))
                        .findFirst()
                        .get();
                Integer key = studentDto.getId();
                log.info("The key of old data is {}", key);
                studentMap.remove(key);
                log.info("Update this student {}  ", studentDto);
                studentMap.put(updatedStudentDto.getId(), updatedStudentDto);
                log.info("Updated {} successfully ", updatedStudentDto);
            } else {
                studentMap.put(id, updatedStudentDto);
            }
        }
        log.info("The key is {}", studentMap.values().stream().findFirst().get().getId());
    }

    public void deleteByEmail(String email) {
        Optional<StudentDto> studentDto = studentMap.values()
                .stream()
                .filter(element -> element.getEmail()
                        .equals(email))
                .findFirst();
        if (studentDto.isEmpty()) {
            log.error("Email not found");
        } else {
            System.out.println(studentDto.get());
            studentMap.remove(studentDto.get().getId());
        }
    }
}