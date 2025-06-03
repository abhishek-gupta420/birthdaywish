package com.abhi.birthdaywish.repository;

import com.abhi.birthdaywish.entities.TwilioConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TwilioConfigRepository extends JpaRepository<TwilioConfigEntity, Integer> {
    Optional<TwilioConfigEntity> findById(Integer id); // use id = 1 for config
}
