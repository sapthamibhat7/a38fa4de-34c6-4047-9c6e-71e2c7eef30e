package com.examly.springapp.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String sayHi(){
        return "Welcome CS";
    }
}
