package com.example.Bench_management.service;

import com.example.Bench_management.Model.Mentor;
import com.example.Bench_management.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id).orElse(null);
    }

    public Mentor addMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Long id, Mentor mentorDetails) {
        Optional<Mentor> optionalMentor = mentorRepository.findById(id);
        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            mentor.setName(mentorDetails.getName());
            mentor.setAvailability(mentorDetails.getAvailability()); // Use setAvailability
            return mentorRepository.save(mentor);
        }
        return null;
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}
