package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Repository {
    private final Student student;
    private final Set<Student> Students = new HashSet<>();
    @Autowired
    public Repository(Student student) {
        this.student = student;
    }

    public void saveStudent (Student student){
        Students.add(student);
    }
    public void saveStudents (Set<Student> students){
        Students.addAll(students);
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


    public void deleteStudent (Integer id){
        Student student = findStudentById(id);
        Students.remove(student);
    }

    public Set<Student> findAll (){

        return Students;
    }

    public Student findStudentById(Integer id) {
        return Students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst() // Returns Optional<Student>
                .orElse(null); // Return null if no student found
    }
}