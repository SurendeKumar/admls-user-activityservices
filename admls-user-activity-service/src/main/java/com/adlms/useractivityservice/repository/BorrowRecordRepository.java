package com.adlms.useractivityservice.repository;

import com.adlms.useractivityservice.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}