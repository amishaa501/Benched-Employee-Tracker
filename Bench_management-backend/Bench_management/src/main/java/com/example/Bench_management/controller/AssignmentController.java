package com.example.Bench_management.controller;

import com.example.Bench_management.Model.Assignment;
import com.example.Bench_management.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/{mentorId}/{candidateId}")
    public Assignment assignMentor(@PathVariable Long mentorId, @PathVariable Long candidateId) {
        return assignmentService.assignMentor(mentorId, candidateId);
    }
}
