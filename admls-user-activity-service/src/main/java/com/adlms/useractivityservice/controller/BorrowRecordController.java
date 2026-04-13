package com.adlms.useractivityservice.controller;

import com.adlms.useractivityservice.dto.BorrowRecordDTOs;
import com.adlms.useractivityservice.service.BorrowRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowRecordController {

    private final BorrowRecordService service;

    public BorrowRecordController(BorrowRecordService service) {
        this.service = service;
    }

    @GetMapping("/users/{userId}/borrow-records")
    public List<BorrowRecordDTOs.BorrowRecordResponse> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @PostMapping("/users/{userId}/borrow-records")
    public BorrowRecordDTOs.BorrowRecordResponse create(
            @PathVariable Long userId,
            @Valid @RequestBody BorrowRecordDTOs.CreateBorrowRecordRequest request
    ) {
        return service.create(userId, request);
    }

    @PutMapping("/users/{userId}/borrow-records/{recordId}")
    public BorrowRecordDTOs.BorrowRecordResponse update(
            @PathVariable Long userId,
            @PathVariable Long recordId,
            @Valid @RequestBody BorrowRecordDTOs.UpdateBorrowRecordRequest request
    ) {
        return service.update(userId, recordId, request);
    }

    @DeleteMapping("/users/{userId}/borrow-records/{recordId}")
    public void delete(
            @PathVariable Long userId,
            @PathVariable Long recordId
    ) {
        service.delete(userId, recordId);
    }
}