package com.sarpio.shoopinglist.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Piotr Sarnecki
 */
@Controller
@CrossOrigin(origins = "*",allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
public class HomeController {

    @GetMapping
    public String index() {
        return "redirect:/list";
    }
}
