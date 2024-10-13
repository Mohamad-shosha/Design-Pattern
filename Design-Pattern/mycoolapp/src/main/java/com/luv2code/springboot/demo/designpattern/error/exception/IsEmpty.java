package com.luv2code.springboot.demo.designpattern.error.exception;


import com.luv2code.springboot.demo.designpattern.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Value
public class IsEmpty extends RuntimeException {
    Integer code = 525;
    String message;
    String description;
    Timestamp currentTime;

    public IsEmpty(String message, String description) {
        this.message = message;
        this.description = description;
        this.currentTime = TimingUtilities.timestamp();
    }

}
