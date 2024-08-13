package com.luv2code.springboot.demo.designpattern.config;

import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
    @Value("${student.id}")
    private int id ;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;
    @Bean
    public Student createStudentBean (){
        return new Student(id,name,age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
