package com.skillsoft.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/organization/")
public class WebServiceController {

    @GetMapping("/")
    public String formPage() {
        return "editName";
    }

    @ResponseBody
    @GetMapping("/info")
    public String myName(@RequestParam(defaultValue = "Skillsoft") String name) {
        return "<h2> Welcome to Spring boot at <i>" + name + "</i> This is an HTTP GET request</h2>";
    }

    @ResponseBody
    @GetMapping("/info/param")
    public String myNameParam(@RequestParam(name = "orgName", defaultValue = "Skillsoft") String name) {
        return "<h2> Welcome to Spring boot at <i>" + name + "</i> This is an HTTP GET request</h2>";
    }

    @ResponseBody
    @GetMapping("/info/path/{name}")
    public String myNamePath(@PathVariable(name = "name") String name) {
        return "<h2> Welcome to Spring boot at <i>" + name + "</i> This is an HTTP GET request</h2>";
    }
}
