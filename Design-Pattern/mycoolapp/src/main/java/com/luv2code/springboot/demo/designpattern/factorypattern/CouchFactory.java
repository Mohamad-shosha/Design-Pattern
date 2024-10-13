package com.luv2code.springboot.demo.designpattern.factorypattern;

import com.luv2code.springboot.demo.designpattern.error.exception.CouchNotFoundException;

public class CouchFactory {
    public Couch createCouch(String couch) {
        return switch (couch) {
            case "Tennis Couch" -> new TennisCouch();
            case "Football Couch" -> new FootballCouch();
            case "Baseball Couch" -> new BaseballCouch();
            default -> throw new CouchNotFoundException("Can not found this couch" + couch);
        };
    }
}
