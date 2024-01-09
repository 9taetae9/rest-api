package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Slf4j
////@Controller // html 형태로 응답
//@RestController // rest api로 동작한다 -> json 형태로 응답
//@RequestMapping("/api/v1")
//public class ResponseApiController {
//
//    // @GetMapping("") =>  http://localhost:8080/api/v1 default 주소로 매핑
//    @GetMapping("")
//    //@RequestMapping(path ="", method = RequestMethod.GET) //RequestMapping 사용시에는 method 지정
//   // @ResponseBody
//    public ResponseEntity<UserRequest> user(){
//
//        var user =new UserRequest("홍길동",10,"hong@gmail.com",true);
////        user.setUserName("홍길동");
////        user.setUserAge(10);
////        user.setEmail("hong@gmail.com");
//
//        log.info("user: {}", user); //user를 {}에 매핑
//
//        var response = ResponseEntity
//                .status(HttpStatus.CREATED)
//                .header("x-custom","hi")
//                .body(user);
//
//        return response;
//    }

    //응답 Object로 응답시 자동으로 json 형태로 변환되어 응답 상태값은 항상 200 ok

//    public String user(){
//
//        var user =new UserRequest();
//        user.setUserName("홍길동");
//        user.setUserAge(10);
//        user.setEmail("hong@gmail.com");
//
//        log.info("user: {}", user); //user를 {}에 매핑
////
////        return user.toString();
////    }
//
//
//}
