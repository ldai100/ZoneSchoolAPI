package com.yfcld.ZoneSchoolAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping
    public String getMessage() {
        return "Hello from public API controller";
    }

    @GetMapping("/successful")
    public String successfulLogin(){
        return "Successful";
    }
}