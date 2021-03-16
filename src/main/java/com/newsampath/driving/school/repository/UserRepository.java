package com.newsampath.driving.school.repository;

import com.newsampath.driving.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}