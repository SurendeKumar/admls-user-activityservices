package com.adlms.useractivityservice.repository;

import com.adlms.useractivityservice.entity.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
}