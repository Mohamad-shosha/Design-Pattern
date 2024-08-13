package com.luv2code.springboot.demo.designpattern.rest;

import com.luv2code.springboot.demo.designpattern.service.DbConnectionWithEager;
import com.luv2code.springboot.demo.designpattern.model.entity.Student;
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

    @GetMapping("/GetStudents")
    public Collection<Student> getStudents() {
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

    @DeleteMapping("/DeleteStudentInParam")
    public ResponseEntity<String> deleteStudentInParamWithId(@RequestParam Integer id) {
        DbConnectionWithEager.getInstance().delete(id);
        return ResponseEntity.ok("Deleting of student complete");
    }
    @DeleteMapping("/DeleteStudentInPath/{id}")
    public ResponseEntity<String> deleteStudentInPathWithId(@PathVariable Integer id) {
        DbConnectionWithEager.getInstance().delete(id);
        return ResponseEntity.ok("Deleting of student complete");
    }


}