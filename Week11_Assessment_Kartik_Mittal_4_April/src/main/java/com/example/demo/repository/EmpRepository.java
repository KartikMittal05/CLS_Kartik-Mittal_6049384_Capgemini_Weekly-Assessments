package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
}