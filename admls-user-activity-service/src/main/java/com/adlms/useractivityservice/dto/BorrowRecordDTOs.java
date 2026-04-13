package com.adlms.useractivityservice.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BorrowRecordDTOs {

    public record CreateBorrowRecordRequest(
            @NotNull Long documentId,
            @NotNull LocalDate borrowDate,
            @NotNull LocalDate dueDate,
            LocalDate returnedDate
    ) {
    }

    public record UpdateBorrowRecordRequest(
            @NotNull Long documentId,
            @NotNull LocalDate borrowDate,
            @NotNull LocalDate dueDate,
            LocalDate returnedDate
    ) {
    }

    public record BorrowRecordResponse(
            Long id,
            Long userId,
            Long documentId,
            LocalDate borrowDate,
            LocalDate dueDate,
            LocalDate returnedDate
    ) {
    }
}