package com.adlms.useractivityservice.service;

import com.adlms.useractivityservice.dto.UserDTOs;
import com.adlms.useractivityservice.entity.LibraryUser;
import com.adlms.useractivityservice.mapper.UserMapper;
import com.adlms.useractivityservice.repository.LibraryUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final LibraryUserRepository repository;

    public UserService(LibraryUserRepository repository) {
        this.repository = repository;
    }

    public UserDTOs.UserResponse create(UserDTOs.CreateUserRequest request) {
        LibraryUser user = new LibraryUser(
                request.name(),
                request.email(),
                request.memberSince()
        );

        return UserMapper.toResponse(repository.save(user));
    }

    public List<UserDTOs.UserResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserDTOs.UserResponse getById(Long id) {
        LibraryUser user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toResponse(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}