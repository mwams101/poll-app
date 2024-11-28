package com.example.pollingapp.controllers;

import com.example.pollingapp.models.Candidate;
import com.example.pollingapp.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping
    public List<Candidate> getCandidates() {

        return candidateRepository.findAll();
    }

}
