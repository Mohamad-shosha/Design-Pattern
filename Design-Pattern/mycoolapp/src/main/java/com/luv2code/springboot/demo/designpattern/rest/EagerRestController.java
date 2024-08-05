package com.luv2code.springboot.demo.designpattern.rest;

import com.luv2code.springboot.demo.designpattern.eagerinstantiation.DbConnectionWithEager;
import com.luv2code.springboot.demo.designpattern.entity.Student;
import com.luv2code.springboot.demo.designpattern.lazyinstantiation.DbConnectionWithLazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("Eager")
public class EagerRestController {

    @PostMapping("/AddStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        DbConnectionWithEager.getInstance().save(student);
        return ResponseEntity.ok("Insertion of student complete");
    }

    @PostMapping("/AddStudents")
    public ResponseEntity<String> addStudents(@RequestBody Set<Student> studentSet) {
        DbConnectionWithLazy.getInstance().addAll(studentSet);
        return ResponseEntity.ok("Insertion of students complete");
    }

    @GetMapping("/GetStudents")
    public Set<Student> getStudents() {
        return DbConnectionWithEager.getInstance().getStudents();
    }

    @GetMapping("/GetStudent/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return DbConnectionWithEager.getInstance().getStudent(id);
    }

    @PutMapping("/UpdateStudent/{id}")
    public ResponseEntity<String> updateStudentWithId(@PathVariable Integer id, @RequestBody Student student) {
        DbConnectionWithEager.getInstance().update(id, student);
        return ResponseEntity.ok("Updating of student complete");
    }

    @DeleteMapping("/DeleteStudent/{id}")
    public ResponseEntity<String> deleteStudentWithId(@PathVariable Integer id) {
        DbConnectionWithEager.getInstance().delete(id);
        return ResponseEntity.ok("Deleting of student complete");
    }

}