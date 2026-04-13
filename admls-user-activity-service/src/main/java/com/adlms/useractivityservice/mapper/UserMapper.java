package com.adlms.useractivityservice.mapper;

import com.adlms.useractivityservice.dto.UserDTOs;
import com.adlms.useractivityservice.entity.LibraryUser;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDTOs.UserResponse toResponse(LibraryUser user) {
        return new UserDTOs.UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getMemberSince()
        );
    }
}