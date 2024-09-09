package com.example.Bench_management.controller;

import com.example.Bench_management.Model.BenchCandidate;
import com.example.Bench_management.service.BenchCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bench-candidates")
@CrossOrigin(origins = "*")
public class BenchCandidateController {

    @Autowired
    private BenchCandidateService benchCandidateService;

    @GetMapping
    public ResponseEntity<List<BenchCandidate>> getAllCandidates() {
        return ResponseEntity.ok(benchCandidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenchCandidate> getCandidateById(@PathVariable Long id) {
        BenchCandidate candidate = benchCandidateService.getCandidateById(id);
        return candidate != null ? ResponseEntity.ok(candidate) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BenchCandidate> addCandidate(@RequestBody BenchCandidate candidate) {
        try {
            BenchCandidate addedCandidate = benchCandidateService.addCandidate(candidate);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCandidate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenchCandidate> updateCandidate(@PathVariable Long id, @RequestBody BenchCandidate candidateDetails) {
        try {
            BenchCandidate updatedCandidate = benchCandidateService.updateCandidate(id, candidateDetails);
            return ResponseEntity.ok(updatedCandidate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        try {
            benchCandidateService.deleteCandidate(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
