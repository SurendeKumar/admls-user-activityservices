package com.adlms.useractivityservice.service;

import com.adlms.useractivityservice.dto.BorrowRecordDTOs;
import com.adlms.useractivityservice.entity.BorrowRecord;
import com.adlms.useractivityservice.entity.LibraryUser;
import com.adlms.useractivityservice.mapper.BorrowRecordMapper;
import com.adlms.useractivityservice.repository.BorrowRecordRepository;
import com.adlms.useractivityservice.repository.LibraryUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final LibraryUserRepository libraryUserRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository,
                               LibraryUserRepository libraryUserRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.libraryUserRepository = libraryUserRepository;
    }

    public BorrowRecordDTOs.BorrowRecordResponse create(Long userId, BorrowRecordDTOs.CreateBorrowRecordRequest request) {
        LibraryUser user = libraryUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BorrowRecord record = new BorrowRecord(
                user,
                request.documentId(),
                request.borrowDate(),
                request.dueDate(),
                request.returnedDate()
        );

        return BorrowRecordMapper.toResponse(borrowRecordRepository.save(record));
    }

    public List<BorrowRecordDTOs.BorrowRecordResponse> getByUser(Long userId) {
        return borrowRecordRepository.findAll()
                .stream()
                .filter(record -> record.getUser().getId().equals(userId))
                .map(BorrowRecordMapper::toResponse)
                .collect(Collectors.toList());
    }

    public BorrowRecordDTOs.BorrowRecordResponse update(Long userId, Long recordId,
                                                        BorrowRecordDTOs.UpdateBorrowRecordRequest request) {
        BorrowRecord record = borrowRecordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        if (!record.getUser().getId().equals(userId)) {
            throw new RuntimeException("Borrow record does not belong to user");
        }

        record.setDocumentId(request.documentId());
        record.setBorrowDate(request.borrowDate());
        record.setDueDate(request.dueDate());
        record.setReturnedDate(request.returnedDate());

        return BorrowRecordMapper.toResponse(borrowRecordRepository.save(record));
    }

    public void delete(Long userId, Long recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        if (!record.getUser().getId().equals(userId)) {
            throw new RuntimeException("Borrow record does not belong to user");
        }

        borrowRecordRepository.delete(record);
    }
}