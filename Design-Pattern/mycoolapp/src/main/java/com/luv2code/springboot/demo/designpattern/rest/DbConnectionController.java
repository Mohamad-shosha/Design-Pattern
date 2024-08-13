package com.luv2code.springboot.demo.designpattern.rest;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import com.luv2code.springboot.demo.designpattern.service.DbConnectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api")
public class DbConnectionController {
    private final DbConnectionService dbConnectionService;
    public DbConnectionController (DbConnectionService dbConnectionService){
        this.dbConnectionService=dbConnectionService;
    }
    @GetMapping("getinfo")
    public Student getInfoOfStudents (){
        return dbConnectionService.getStudentInfo();
    }
}
