package com.abhi.birthdaywish.repository;

import com.abhi.birthdaywish.entities.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailConfigRepository extends JpaRepository<EmailConfig, Integer> {
    // You can add custom queries here if needed
}
