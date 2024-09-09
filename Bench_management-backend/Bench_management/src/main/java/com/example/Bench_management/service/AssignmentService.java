package com.example.Bench_management.service;

import com.example.Bench_management.Model.Assignment;
import com.example.Bench_management.Model.BenchCandidate;
import com.example.Bench_management.Model.Mentor;
import com.example.Bench_management.repository.AssignmentRepository;
import com.example.Bench_management.repository.BenchCandidateRepository;
import com.example.Bench_management.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private BenchCandidateRepository candidateRepository;

    public Assignment assignMentor(Long mentorId, Long candidateId) {
        Mentor mentor = mentorRepository.findById(mentorId).orElse(null);
        BenchCandidate candidate = candidateRepository.findById(candidateId).orElse(null);

        if (mentor == null || candidate == null) {
            return null; // or throw an exception
        }

        Assignment assignment = new Assignment();
        assignment.setMentor(mentor);
        assignment.setCandidate(candidate);

        return assignmentRepository.save(assignment);
    }
}
