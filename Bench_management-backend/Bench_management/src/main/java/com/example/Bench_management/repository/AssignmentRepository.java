package com.example.Bench_management.repository;


import com.example.Bench_management.Model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
