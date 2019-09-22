package org.randall.teagan.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefualtController {

    @RequestMapping(value = {"/", "/capstone"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to the homepage of the capstone application.", HttpStatus.OK);
    }
}
