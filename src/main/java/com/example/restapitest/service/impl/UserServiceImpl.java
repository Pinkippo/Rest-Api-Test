package com.example.restapitest.service.impl;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.data.repository.UserRepository;
import com.example.restapitest.service.UserService;
import jakarta.transaction.Transactional;
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



    @Transactional
    public void update(Long id, String name, String password){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        userEntity.setName(name);
        userEntity.setPassword(password);
    }

}
