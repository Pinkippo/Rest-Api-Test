package com.example.restapitest.service;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional
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
