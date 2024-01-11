package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<UserRegisterRequest> register( //Api의 스펙을 통해서만 json을 보낼수 있게 함
                                           //요청받을 데이터 모델 필라

        @Valid
        @RequestBody
        Api<UserRegisterRequest> userRegisterRequest

                                        //   BindingResult bindingResult
    ){
        log.info("{}",userRegisterRequest);

//        if(bindingResult.hasErrors()){
////            var errorMessageList = bindingResult.getFieldErrors().stream()
////                    .map(it->{
////                        var format = "%s : { %s } 은  %s";
////                        var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
////                        return message;
////                    }).collect(Collectors.toList());
////
////            var error = Api.Error
////                    .builder()
////                    .errorMessage(errorMessageList)
////                    .build();
////
////            var errorResponse = Api
////                    .builder()
////                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
////                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
////                    .error(error)
////                    .build();
////
////            return errorResponse;
//        }

        var body = userRegisterRequest.getData();

        var response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}
