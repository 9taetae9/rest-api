package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
@Builder //빌더 패턴
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
   //@NotNull  //!=nul
   //@NotEmpty //!=null && name !=""
    //@NotBlank //!=null && name !="" && name !=" "
    private String name;

    private String nickName;

    @Size(min=1, max =12) // 1~12
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") //핸드폰 번호 정규식
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message =  "name or nickName은 존재해야 합니다.")
    //@AssertFalse false를 리턴하여야함!
    public boolean isNameCheck(){ //"is"를 붙여야 동작한다

        if(Objects.nonNull(name) && !name.isBlank()){
         return true;
        }

        if(Objects.nonNull(nickName) && !nickName.isBlank()){
          return true;
        }

        return false; //둘다 null이거나 빈문자열일 경우 flase리턴
    }
}
