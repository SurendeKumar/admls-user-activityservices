package com.adlms.useractivityservice.repository;

import com.adlms.useractivityservice.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
	List<BorrowRecord> findByDocumentId(long documentId);
}