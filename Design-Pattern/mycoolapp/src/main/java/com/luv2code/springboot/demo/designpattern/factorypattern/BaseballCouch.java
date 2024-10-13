package com.luv2code.springboot.demo.designpattern.factorypattern;

public class BaseballCouch implements Couch{

    @Override
    public String getDailyWorkout() {
        return ("Play Baseball 3 times in week");
    }
}
