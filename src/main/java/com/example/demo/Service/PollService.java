package com.example.demo.Service;

import com.example.demo.Entity.Poll;
import com.example.demo.Repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //The annotation @RequiredArgsConstructor automatically generates a constructor
// for pollRepository.

public class PollService {
    @Autowired
    private  PollRepository pollRepository;

    public Poll createPoll(Poll poll){


        //poll.setActive(true);
        return pollRepository.save(poll);
    }
    public List<Poll> getActivePolls(){
        return pollRepository.findByIsActiveTrue();
    }
}
