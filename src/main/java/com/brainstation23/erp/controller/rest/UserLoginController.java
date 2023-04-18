package com.brainstation23.erp.controller.rest;

import com.brainstation23.erp.service.LoginService;
import com.brainstation23.erp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authentic")
@Tag(name = "Login")
@Slf4j
@RequiredArgsConstructor
public class UserLoginController {

    //@Autowired
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestParam(name  ="email") String email,  @RequestParam(name = "password") String password){
        log.info("trying to login using email={} and password={} ", email, password);
        return loginService.getJwtToken(email,password);
    }

}
