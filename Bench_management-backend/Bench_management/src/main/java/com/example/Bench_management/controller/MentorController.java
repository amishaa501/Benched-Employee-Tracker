package com.example.Bench_management.controller;

import com.example.Bench_management.Model.Mentor;
import com.example.Bench_management.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentors")
@CrossOrigin(origins = "*")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAllMentors();
        return ResponseEntity.ok(mentors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable Long id) {
        Mentor mentor = mentorService.getMentorById(id);
        return mentor != null ? ResponseEntity.ok(mentor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor) {
        try {
            Mentor addedMentor = mentorService.addMentor(mentor);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedMentor);
        } catch (Exception e) {
            // Log the exception if needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Long id, @RequestBody Mentor mentor) {
        try {
            Mentor updatedMentor = mentorService.updateMentor(id, mentor);
            return ResponseEntity.ok(updatedMentor);
        } catch (Exception e) {
            // Log the exception if needed
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable Long id) {
        try {
            mentorService.deleteMentor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception if needed
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
