package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

    @Autowired //spring에서 관리하는 bean들 중에 자동으로 생성된느 오브젝트 매퍼를 가저옴
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        //var user = new UserRequest("홍길동",10,"hong@gmail.com",true);
        //System.out.println(user);
//        user.setUserName("홍길동");
//        user.setUserAge(10);
//        user.setEmail("hong@gmail.com");
//        user.setIsKorean(true);

        //var json = objectMapper.writeValueAsString(user); //dto -> json (objectMapper를 통해 직렬화)
        var json = "{\"user_names\":\"홍길동\",\"user_age\":10,\"email\":\"hong@gmail.com\",\"is_korean\":true}";
        System.out.println(json);
        //{"user_name":"홍길동","user_age":10,"email":"hong@gmail.com","is_korean":true}


        var dto = objectMapper.readValue(json, UserRequest.class); //json -> dto (objectMapper를 통해 역직렬화)
        System.out.println(dto);
        //UserRequest(userName=홍길동, userAge=10, email=hong@gmail.com, isKorean=true)
    }

}
