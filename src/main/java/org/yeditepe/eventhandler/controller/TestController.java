package org.yeditepe.eventhandler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "EventHandler is running ✅";
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
