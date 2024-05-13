package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index() {
        return "user/principal";
    }

   
    @GetMapping("/error")
    public String error() {
        return "user/error";
    }
   
    
}
