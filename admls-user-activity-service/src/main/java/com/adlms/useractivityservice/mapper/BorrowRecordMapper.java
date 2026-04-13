package com.adlms.useractivityservice.mapper;

import com.adlms.useractivityservice.dto.BorrowRecordDTOs;
import com.adlms.useractivityservice.entity.BorrowRecord;

public class BorrowRecordMapper {

    private BorrowRecordMapper() {
    }

    public static BorrowRecordDTOs.BorrowRecordResponse toResponse(BorrowRecord record) {
        return new BorrowRecordDTOs.BorrowRecordResponse(
                record.getId(),
                record.getUser().getId(),
                record.getDocumentId(),
                record.getBorrowDate(),
                record.getDueDate(),
                record.getReturnedDate()
        );
    }
}