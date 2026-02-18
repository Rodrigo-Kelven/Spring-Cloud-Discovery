package com.example.serviceb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service-b")
public class ServiceBRestController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service B!";
    }
}