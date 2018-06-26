package com.individual.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserCreation, Long> {
    List<UserCreation> findByFirstNameAndLastName(String partial, String partial2);
    List<UserCreation> findByFirstName(String partial);
    List<UserCreation> findByLastName(String partial);
    List<UserCreation> findByAccountNumber(Long exact);
}
