package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="polls")
public class Poll {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String question;
    @ElementCollection
    private List<String> options;
    private boolean isActive;
//Getters and Setters
    public boolean isActive(){
        return isActive;
    }
    public void setActive(boolean active) {
        this.isActive =active;
    }
}
