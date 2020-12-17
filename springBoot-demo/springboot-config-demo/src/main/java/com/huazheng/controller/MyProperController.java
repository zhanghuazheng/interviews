package com.huazheng.controller;

import com.huazheng.entiy.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyProperController {
    @Autowired
    private Person person;

    @GetMapping("/zhz")
    public String getPerson(){
        return person.toString();
    }

    @GetMapping("/chx")
    public String getPersonByMyFile(){
        return person.toString();
    }
}
