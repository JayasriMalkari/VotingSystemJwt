package com.example.demo.Service;

import com.example.demo.Entity.Vote;
import com.example.demo.Repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private  VoteRepository voteRepository;

    //Manually add a COnstructor
//    public VoteService(VoteRepository voteRepository) {
//        this.voteRepository = voteRepository;
//    }

    public Vote castVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
