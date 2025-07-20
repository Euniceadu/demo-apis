package com.eunice.demos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        @NotBlank(message = "Name is required") String firstName,
        @NotBlank(message = "Name is required") String lastName,
        @Email(message = "Please enter a valid email address") String email,
        @NotBlank(message = "") @Size(min = 6, max = 20) String password
) {}