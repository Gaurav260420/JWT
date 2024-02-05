package com.sign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
@Controller
@RequestMapping("/raj")
public class LoginController {
    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }
}



