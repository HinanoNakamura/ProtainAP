package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.backend.domain.Users;

public interface UserRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{
    Optional<Users> findById(String id);
}
