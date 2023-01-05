package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDTO {
    private String name;
    private String password;

    @Builder
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
