package com.iti.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@RestController
public class DemoController {

    @Autowired
    private ServletRequest request;

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/")
    public String index() {
        String ip = request.getRemoteAddr();

        logger.info("request from ip {}", ip);
        return "Greetings from Spring Boot!";
    }

}
