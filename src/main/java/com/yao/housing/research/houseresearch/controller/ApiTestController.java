package com.yao.housing.research.houseresearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTestController {

    @GetMapping("/hello-world")
    @ResponseBody
    public String sayHello() {
        return "hello";
    }
}
