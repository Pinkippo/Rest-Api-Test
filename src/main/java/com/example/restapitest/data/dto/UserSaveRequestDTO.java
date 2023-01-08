package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // GETTER 메서드 추가
@NoArgsConstructor // 기본 생성자 추가 + final 있으면 오류남
public class UserSaveRequestDTO {
    private String name;
    private String password;

    public UserSaveRequestDTO(String name, String password){
        this.name = name;
        this.password = password;
    } // setter를 없애고 생성자로 데이터를 초기화 해서 계층간에 DTO가 변조되지 않게 함


    public User toEntity(){
        return User.builder()
                .name(name)
                .password(password)
                .build();
    }

}
