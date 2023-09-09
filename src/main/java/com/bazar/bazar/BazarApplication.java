package com.bazar.bazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class BazarApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazarApplication.class, args);
    }

    @RequestMapping(value = "/{path:[^\\.]*}", method = RequestMethod.GET)
    public String forward() {
        return "forward:/index.html";
    }

}
