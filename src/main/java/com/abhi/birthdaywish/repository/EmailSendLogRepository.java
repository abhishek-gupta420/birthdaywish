package com.abhi.birthdaywish.repository;

import com.abhi.birthdaywish.entities.EmailSendLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSendLogRepository extends JpaRepository<EmailSendLog, Long> {
    // You can define custom queries here if needed
}
