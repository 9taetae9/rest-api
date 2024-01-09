package com.example.restapi.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    private Boolean isKorean;  // setIsKorean(Boolean)이 생성됨 => "is_korean" : true 사용가능

    //private boolean isKorean; //boolean타입 default 값이 false여서 setKorean()으로 만들어지게 됨
    //"is_korean" : true 으로 요청시 인식 못함 => "korean" : true 으로 바꾸면 요청가능하긴함(권장은 x)
    // primitive 타입이 아닌 reference 타입의 Boolean을 사용하는 것을 권장
}
