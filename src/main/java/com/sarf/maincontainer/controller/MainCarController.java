package com.sarf.maincontainer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/main")
@Slf4j
public class MainCarController {


    @GetMapping
    public String sayHello() {
        return "Hello! I am a main car app";
    }

    @GetMapping(path = "/side")
    public String sayHelloFromSide() {
        return new RestTemplate().getForObject("http://localhost:8081/side", String.class);
    }

    @GetMapping(path = "/side-rep")
    public String sayHelloFromSideRep() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            log.info( "id : " +i + " FROM MAIN : " + new RestTemplate().getForObject("http://localhost:8081/side", String.class));
        }
        log.info("COMPLETED");
        return "Completed";
    }

}
