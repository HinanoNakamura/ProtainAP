package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.backend.domain.Testes;

public interface TestRepository extends JpaRepository<Testes, Integer>,JpaSpecificationExecutor<Testes> {

}
