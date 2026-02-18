package com.example.servicea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-a")
public class ServiceARestController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }

}