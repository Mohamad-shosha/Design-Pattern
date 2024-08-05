package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {
    private final Student student;
    private final List<Student> students = new ArrayList<>();

    @Autowired
    public Repository(Student student) {
        this.student = student;
    }

    public void saveStudent(Student student) {
        students.add(student);
    }

    public void saveStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void updateStudent(Integer id, Student updatedStudent) {
        Student studentToUpdate = findStudentById(id);

        if (studentToUpdate != null) {
            // Update the student with the new information
            studentToUpdate.setId(updatedStudent.getId());
            studentToUpdate.setName(updatedStudent.getName());
            studentToUpdate.setAge(updatedStudent.getAge());
            // Add more fields as needed
        } else {
            // Handle case where no student with the given ID is found
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(Integer id) {
        Student student = findStudentById(id);
        students.remove(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findStudentById(Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst() // Returns Optional<Student>
                .orElse(null); // Return null if no student found
    }
}