package com.eunice.demos.controller;

import com.eunice.demos.dto.request.CreateUserDTO;
import com.eunice.demos.dto.response.UserResponseDTO;
import com.eunice.demos.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserManagementController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{email}")
    public UserResponseDTO getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping()
    public UserResponseDTO createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }
}
