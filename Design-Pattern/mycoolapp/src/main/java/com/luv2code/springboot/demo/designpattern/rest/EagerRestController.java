package com.luv2code.springboot.demo.designpattern.rest;

import com.luv2code.springboot.demo.designpattern.service.DbConnectionWithEagerImpl;
import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("Eager")
public class EagerRestController {

    @PostMapping("/AddStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto) {
        DbConnectionWithEagerImpl.getInstance().save(studentDto);
        return ResponseEntity.ok("Insertion of student complete");
    }

    @GetMapping("/GetStudents")
    public Collection<StudentDto> getStudents() {
        return DbConnectionWithEagerImpl.getInstance().getStudents();
    }

    @GetMapping("/GetStudent/{id}")
    public StudentDto getStudent(@PathVariable Integer id) {
        return DbConnectionWithEagerImpl.getInstance().getStudent(id);
    }

    @PutMapping("/UpdateStudent/{id}")
    public ResponseEntity<String> updateStudentWithId(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        DbConnectionWithEagerImpl.getInstance().update(id, studentDto);
        return ResponseEntity.ok("Updating of student complete");
    }

    @DeleteMapping("/DeleteStudentInParam")
    public ResponseEntity<String> deleteStudentInParamWithId(@RequestParam Integer id) {
        DbConnectionWithEagerImpl.getInstance().deleteById(id);
        return ResponseEntity.ok("Deleting of student complete");
    }
    @DeleteMapping("/DeleteStudentInPath/{id}")
    public ResponseEntity<String> deleteStudentInPathWithId(@PathVariable Integer id) {
        DbConnectionWithEagerImpl.getInstance().deleteById(id);
        return ResponseEntity.ok("Deleting of student complete");
    }


}