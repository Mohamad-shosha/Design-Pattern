package com.luv2code.springboot.demo.designpattern.factorypattern;

public class FootballCouch implements Couch {

    @Override
    public String getDailyWorkout() {
        return ("Play football 7 times in the week");
    }
}
