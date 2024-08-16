package com.luv2code.springboot.demo.designpattern.rest;

import com.luv2code.springboot.demo.designpattern.model.entity.StudentDto;
import com.luv2code.springboot.demo.designpattern.service.DbConnectionWithLazyImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("Lazy")
public class LazyRestController {

    private final DbConnectionWithLazyImpl dbConnectionWithLazyImpl;

    public LazyRestController(DbConnectionWithLazyImpl dbConnectionWithLazyImpl) {
        this.dbConnectionWithLazyImpl = dbConnectionWithLazyImpl.getInstance();
    }

    @PostMapping("/AddStudent")
    public void addStudent(@RequestBody StudentDto studentDto) {
       /* DbConnectionWithLazy dbConnectionWithLazy =DbConnectionWithLazy.getInstance();
        Student student = new Student(3,"Karim",27);*/
        dbConnectionWithLazyImpl.save(studentDto);
    }

    @GetMapping("/GetStudent/{id}")
    public StudentDto getStudent(@PathVariable(value = "id") Integer key) {
        return dbConnectionWithLazyImpl.getStudent(key);
    }

    @GetMapping("/GetStudents")
    public Collection<StudentDto> getStudents() {
        return dbConnectionWithLazyImpl.getStudents();
    }

    @PutMapping("/UpdateStudent/{id}")
    public void updateStudent(@RequestBody StudentDto studentDto, @PathVariable(value ="id") Integer id) {
        dbConnectionWithLazyImpl.update(id, studentDto);
    }

    @DeleteMapping("/DeleteStudent")
    public void deleteStudent(@RequestParam(value = "id") Integer id) {
        dbConnectionWithLazyImpl.deleteById(id);
    }

    @DeleteMapping("/DeleteStudentByEmail")
    public void deleteStudentByEmail(@RequestParam(value = "email") String email) {
        dbConnectionWithLazyImpl.deleteByEmail(email);
    }


}