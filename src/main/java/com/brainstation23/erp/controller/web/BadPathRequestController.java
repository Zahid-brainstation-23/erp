package com.brainstation23.erp.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class BadPathRequestController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        log.info("Bad Path Request");
        return "error";
    }
}