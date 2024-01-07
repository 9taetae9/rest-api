package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello() {
        var html = "<html><body><h1>Hello Spring Boot</h1></body></html>";
        return html;
    }

    // Existing String echo method
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable(name = "message") String msg,
                       @PathVariable int age,
                       @PathVariable boolean isMan
    ) {
        System.out.println("echo message: " + msg); // Log message
        System.out.println("echo message: " + age);
        System.out.println("echo message: " + isMan);
        return msg.toUpperCase();
    }

    // Overloaded echo method for Integer type
    @GetMapping(path = "/echo/int/{number}")
    public String echo(@PathVariable(name = "number") Integer number) {
        System.out.println("echo number: " + number); // Log number
        return "Number: " + number;
    }

    // Overloaded echo method for Boolean type
    @GetMapping(path = "/echo/bool/{flag}")
    public String echo(@PathVariable(name = "flag") Boolean flag) {
        System.out.println("echo flag: " + flag); // Log flag
        return "Boolean: " + flag;
    }
    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }
}
