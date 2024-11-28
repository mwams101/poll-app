package com.example.pollingapp.controllers;

import com.example.pollingapp.models.Candidate;
import com.example.pollingapp.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class VoteController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/vote/{candidateId}")
    @SendTo("/topic/votes")
    public Candidate vote(@DestinationVariable Long CandidateId){
        Candidate candidate = candidateRepository.findById(CandidateId).
                orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setVotes(candidate.getVotes() + 1);
        candidateRepository.save(candidate);

        messagingTemplate.convertAndSend("/topic/votes", candidate);
        return candidate;

    }
}
