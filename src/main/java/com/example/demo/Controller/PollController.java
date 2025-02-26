package com.example.demo.Controller;

import com.example.demo.Service.PollService;
import com.example.demo.Entity.Poll;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
//@RequiredArgsConstructor //Lombok will generate a constructor for pollService
@Tag(name = "Poll Controller",description = "Endpoints for managing polls")

public class PollController {
    private final PollService pollService;//pollService must be initialized in a constructor
    // Manually adding a constructor
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }


    @PostMapping("/create")
    @Operation(summary = "Create a new poll")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        return ResponseEntity.ok(pollService.createPoll(poll));
    }
    @GetMapping("/active")
    @Operation(summary = "Get active polls")
    public ResponseEntity<List<Poll>> getActivePolls() {
        return ResponseEntity.ok(pollService.getActivePolls());
    }
}
