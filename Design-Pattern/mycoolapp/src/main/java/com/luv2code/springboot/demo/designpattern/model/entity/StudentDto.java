package com.luv2code.springboot.demo.designpattern.model.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class StudentDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private Address address;

    public StudentDto() {
    }

    public StudentDto(Integer id, String name,String email, int age , Address address) {
        this.id = id;
        this.name = name;
        this.email=email;
        this.age = age;
        this.address=address;
    }


    @Autowired(required = false)
    public void setAddress(Address address) {
        this.address = address;
        if (Objects.nonNull(address)) {
            System.out.println("Setter Injection Occurred for Address inside Student");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return age == that.age && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}