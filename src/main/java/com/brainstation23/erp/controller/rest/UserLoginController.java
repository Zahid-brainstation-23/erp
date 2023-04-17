package com.brainstation23.erp.controller.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/login")
@Tag(name = "Login")
@Slf4j
public class UserLoginController {

    @PostMapping
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("done", HttpStatus.NOT_FOUND);
    }

}
