package com.example.milionaire.milionaire.form;

import java.util.List;

import com.example.milionaire.milionaire.entity.Question;

public class GameForm {
    private Long profileId;
    private List<Question> questions; // pridaj getter/setter

    // gettery/settery
    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }

    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }
}
