package com.individual.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagement {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
