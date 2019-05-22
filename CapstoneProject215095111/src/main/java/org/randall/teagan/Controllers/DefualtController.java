package org.randall.teagan.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefualtController {

    @GetMapping("/")
    @ResponseBody
    public String getHome() {
        return "Default Home";
    }
}
