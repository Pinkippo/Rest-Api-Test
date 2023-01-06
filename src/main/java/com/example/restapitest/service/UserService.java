package com.example.restapitest.service;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String saveUser(UserSaveRequestDTO userSaveRequestDTO){

            userRepository.save(userSaveRequestDTO.toEntity());
            return userSaveRequestDTO.getName();
    }

    public UserEntity getUser(Long id){
        UserEntity userEntity = userRepository.findOne(id);
        return userEntity;
    }

    public List<UserEntity> findMembers() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(Long id, String name, String password){
        UserEntity userEntity = userRepository.findOne(id);
        userEntity.setName(name);
        userEntity.setPassword(password);
    }
}
