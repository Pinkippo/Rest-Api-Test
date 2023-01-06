package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.UserEntity;
import lombok.Builder;
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
    }


    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .password(password)
                .build();
    }

}
