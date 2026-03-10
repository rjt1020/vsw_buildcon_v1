package com.vswbuildcon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    /**
     * Maps the root URL (/) to the index.html file located in src/main/resources/static/
     * This is efficient for serving simple landing pages while keeping Spring Boot flexibility.
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}