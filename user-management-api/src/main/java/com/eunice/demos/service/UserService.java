package com.eunice.demos.service;

import com.eunice.demos.dto.request.CreateUserDTO;
import com.eunice.demos.dto.response.UserResponseDTO;
import com.eunice.demos.entity.User;
import com.eunice.demos.mapper.UserMapper;
import com.eunice.demos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::userToUserResponseDTO).orElse(null);
    }

    public UserResponseDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(userMapper::userToUserResponseDTO).orElse(null);
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserResponseDTOs(users);
    }

    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
        User user = User.builder().email(createUserDTO.email())
                .firstName(createUserDTO.firstName())
                .lastName(createUserDTO.lastName())
                .password(createUserDTO.password())
                .build();
        return userMapper.userToUserResponseDTO(userRepository.save(user));
    }
}
