package com.luv2code.springboot.demo.designpattern.studentcontroller;

import com.luv2code.springboot.demo.designpattern.factorypattern.Couch;
import com.luv2code.springboot.demo.designpattern.factorypattern.CouchFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api")
public class FactoryTest {

    @GetMapping("Factory/{neededCouch}")
    public String getCouch(@PathVariable String neededCouch) {
        CouchFactory factory = new CouchFactory();
        Couch couch = factory.createCouch(neededCouch);
        return couch.getDailyWorkout();
    }

}
