package com.adlms.useractivityservice.controller;

import com.adlms.useractivityservice.dto.UserDTOs;
import com.adlms.useractivityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTOs.UserResponse create(@Valid @RequestBody UserDTOs.CreateUserRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<UserDTOs.UserResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserDTOs.UserResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}