package com.example.demo.Controller;

import com.example.demo.Service.VoteService;
import com.example.demo.Entity.Vote;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
@Tag(name = "Vote Controller", description = "Endpoints for voting")

public class VoteController {
    private  VoteService voteService;
//    // Manually add the constructor if needed
//    public VoteController(VoteService voteService) {
//        this.voteService = voteService;
//    }
    @PostMapping("/cast")
    @Operation(summary = "Cast a vote")
    public ResponseEntity<Vote> castVote(@RequestBody Vote vote) {
        return ResponseEntity.ok(voteService.castVote(vote));
    }
}
