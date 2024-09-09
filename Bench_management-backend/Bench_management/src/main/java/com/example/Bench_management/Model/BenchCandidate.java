package com.example.Bench_management.Model;

import jakarta.persistence.*;

@Entity
public class BenchCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String doj;
    private String benchStartDate;
    private String skills;
    private String interviewsScheduled;
    private String remarks;
    private String aging;
    private String resume;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

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

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getBenchStartDate() {
        return benchStartDate;
    }

    public void setBenchStartDate(String benchStartDate) {
        this.benchStartDate = benchStartDate;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getInterviewsScheduled() {
        return interviewsScheduled;
    }

    public void setInterviewsScheduled(String interviewsScheduled) {
        this.interviewsScheduled = interviewsScheduled;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
