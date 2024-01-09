package com.example.restapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    @JsonProperty("user_names")  // json data와 매핑하기 위함 user_name이 아닌 user_names여서 매핑이 기본적으로 안되서 null리턴
    private String userName;

    private Integer userAge;

    private String email;

    private Boolean isKorean;  // setIsKorean(Boolean)이 생성됨 => "is_korean" : true 사용가능

    //    public String getName(){
//        return this.userName;
//    }
//
//    public int getHumanAge(){
//        return this.userAge;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public Integer getUserAge() {
//        return userAge;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Boolean getIsKorean() {
//        return isKorean;
//    }
//
//    @JsonIgnore //object mapper 관여하는 클래스에서 json 으로 사용하지 않음을 명시
//    public String getUser() {
//        return userName;
//    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
//private boolean isKorean; //boolean타입 default 값이 false여서 setKorean()으로 만들어지게 됨
    //"is_korean" : true 으로 요청시 인식 못함 => "korean" : true 으로 바꾸면 요청가능하긴함(권장은 x)
    // primitive 타입이 아닌 reference 타입의 Boolean을 사용하는 것을 권장
}
