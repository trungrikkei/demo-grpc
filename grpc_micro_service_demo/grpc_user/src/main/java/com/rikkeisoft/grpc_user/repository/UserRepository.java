package com.rikkeisoft.grpc_user.repository;

import com.rikkeisoft.grpc_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "Select * FROM users WHERE id = :id", nativeQuery = true)
    Optional<User> findById(Long id);
}
