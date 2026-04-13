package com.adlms.useractivityservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UserDTOs {

    public record CreateUserRequest(
            @NotBlank String name,
            @NotBlank @Email String email,
            @NotNull LocalDate memberSince
    ) {
    }

    public record UserResponse(
            Long id,
            String name,
            String email,
            LocalDate memberSince
    ) {
    }
}