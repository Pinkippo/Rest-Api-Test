package com.example.restapitest.testcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class infocontroller {

    @GetMapping(value = "/info")
    public String testInfo(){
        return "hello";
    }

}
