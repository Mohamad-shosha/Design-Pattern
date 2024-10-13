
package com.luv2code.springboot.demo.designpattern.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Data
@ToString
@Component
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class StudentDto {
    @NonNull
    @Size(min = 2, max = 30, message = "Name is required and should be between 2 and 30 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @NonNull
    @Email(message = "Email is not Valid")
    private String email;
    @NonNull
    @Min(value = 5, message = "Student is required and must be elder that 5 years")
    @Max(value = 10, message = "Student is required and must be younger that 10 years")
    private int age;
    private AddressDto addressDto;

    @Autowired(required = false)
    public void setAddress(AddressDto addressDto) {
        this.addressDto = addressDto;
        if (Objects.nonNull(addressDto)) {
            log.info("Setter inject completely ");
        }
    }
}
