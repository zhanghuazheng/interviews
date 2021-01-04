package com.huazheng.controller;

import com.huazheng.entiy.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class MyProperController {
    @Resource
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
