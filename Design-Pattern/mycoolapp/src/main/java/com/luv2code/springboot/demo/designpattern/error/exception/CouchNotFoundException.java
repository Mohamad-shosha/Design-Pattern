package com.luv2code.springboot.demo.designpattern.error.exception;

import com.luv2code.springboot.demo.designpattern.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Value
public class CouchNotFoundException extends RuntimeException {
    Integer errorCode = 546;
    String errorMassage = "No such couch exception";
    String errorDescription;
    Timestamp currentTimestamp;

    public CouchNotFoundException(String Description) {
        this.errorDescription = Description;
        this.currentTimestamp = TimingUtilities.timestamp();
    }
}
