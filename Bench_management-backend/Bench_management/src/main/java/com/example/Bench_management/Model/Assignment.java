package com.example.Bench_management.Model;

import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private BenchCandidate candidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public BenchCandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(BenchCandidate candidate) {
        this.candidate = candidate;
    }

    // Getters and Setters
}
