package com.abhi.birthdaywish.repository;

import com.abhi.birthdaywish.entities.BdaywishMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdaywishMessageRepository extends JpaRepository<BdaywishMessage, Long> {
}