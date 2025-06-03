package com.abhi.birthdaywish.repository;

import com.abhi.birthdaywish.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE MONTH(p.dob)=:month AND DAY(p.dob)=:day")
    List<Person> findBirthdayMatches(@Param("month") int month,
                                     @Param("day")   int day);

}
