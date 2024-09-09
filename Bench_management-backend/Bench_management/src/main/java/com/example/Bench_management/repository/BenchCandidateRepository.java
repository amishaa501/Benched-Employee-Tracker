package com.example.Bench_management.repository;

import com.example.Bench_management.Model.BenchCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchCandidateRepository extends JpaRepository<BenchCandidate, Long> {
}
