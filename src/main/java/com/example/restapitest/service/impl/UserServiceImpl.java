package com.example.restapitest.service.impl;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.data.repository.UserRepository;
import com.example.restapitest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long saveUser(UserSaveRequestDTO userSaveRequestDTO){

        return userRepository.save(userSaveRequestDTO.toEntity()).getId();
    }

    public UserEntity getUser(Long id){
        UserEntity userEntity = userRepository.getById(id);
        return userEntity;
    }

}
