package com.example.Bench_management.service;

import com.example.Bench_management.Model.BenchCandidate;
import com.example.Bench_management.repository.BenchCandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BenchCandidateService {

    @Autowired
    private BenchCandidateRepository benchCandidateRepository;

    public List<BenchCandidate> getAllCandidates() {
        return benchCandidateRepository.findAll();
    }

    public BenchCandidate getCandidateById(Long id) {
        return benchCandidateRepository.findById(id).orElse(null);
    }

    public BenchCandidate addCandidate(BenchCandidate candidate) {
        return benchCandidateRepository.save(candidate);
    }

    public BenchCandidate updateCandidate(Long id, BenchCandidate candidateDetails) {
        BenchCandidate candidate = benchCandidateRepository.findById(id).orElse(null);
        if (candidate != null) {
            candidate.setName(candidateDetails.getName());
            candidate.setDoj(candidateDetails.getDoj());
            candidate.setSkills(candidateDetails.getSkills());
            candidate.setRemarks(candidateDetails.getRemarks());
            candidate.setBenchStartDate(candidateDetails.getBenchStartDate());
            candidate.setInterviewsScheduled(candidateDetails.getInterviewsScheduled());
            candidate.setAging(candidateDetails.getAging());
            candidate.setResume(candidateDetails.getResume());
            return benchCandidateRepository.save(candidate);
        }
        return null;
    }

    public void deleteCandidate(Long id) {
        benchCandidateRepository.deleteById(id);
    }
}
