package com.example.restapitest.service;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import jakarta.transaction.Transactional;

public interface UserService {

    Long saveUser(UserSaveRequestDTO userSaveRequestDTO);

    UserEntity getUser(Long id);

    void update(Long id, String name, String password);

}
