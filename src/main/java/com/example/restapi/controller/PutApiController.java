package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public void put(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("Request : {}", userRequest); //log를 통해 출력
       // System.out.println("") 보다 처리 속도 빠름 (프로그램 성능면에서 log 사용)
    }
}
