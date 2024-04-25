package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/principal")
    public String index() {
        return "user/principal";
    }

}
