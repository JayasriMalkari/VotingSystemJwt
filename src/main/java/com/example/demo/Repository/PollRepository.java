package com.example.demo.Repository;

import com.example.demo.Entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    List<Poll> findByIsActiveTrue();
}
