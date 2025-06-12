package com.example.milionaire.milionaire.entity;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correct; // napr. "A", "B", "C", "D"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Gettery a settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getOptionA() { return optionA; }
    public void setOptionA(String optionA) { this.optionA = optionA; }
    public String getOptionB() { return optionB; }
    public void setOptionB(String optionB) { this.optionB = optionB; }
    public String getOptionC() { return optionC; }
    public void setOptionC(String optionC) { this.optionC = optionC; }
    public String getOptionD() { return optionD; }
    public void setOptionD(String optionD) { this.optionD = optionD; }
    public String getCorrect() { return correct; }
    public void setCorrect(String correct) { this.correct = correct; }
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
}
