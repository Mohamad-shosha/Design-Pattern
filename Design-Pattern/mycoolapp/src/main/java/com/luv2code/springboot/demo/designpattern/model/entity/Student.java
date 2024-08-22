package com.luv2code.springboot.demo.designpattern.model.entity;

import com.luv2code.springboot.demo.designpattern.model.dto.AddressDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Data
@Slf4j
@ToString
@Component
@EqualsAndHashCode
public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
    private AddressDto addressDto;

    public Student() {
    }

    public Student(String id, String name, String email, int age, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.addressDto = addressDto;
    }

    @Autowired(required = false)
    public void setAddress(AddressDto addressDto) {
        this.addressDto = addressDto;
        if (Objects.nonNull(addressDto)) {
            log.info("Setter inject completely ");
        }
    }
}
