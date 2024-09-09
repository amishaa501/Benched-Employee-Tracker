package com.example.Bench_management.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String availability; // Changed from boolean to String

    @OneToMany(mappedBy = "mentor")
    private List<BenchCandidate> assignedCandidates;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public List<BenchCandidate> getAssignedCandidates() {
        return assignedCandidates;
    }

    public void setAssignedCandidates(List<BenchCandidate> assignedCandidates) {
        this.assignedCandidates = assignedCandidates;
    }
}
