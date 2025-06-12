package com.example.milionaire.milionaire.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.entity.Question;
import com.example.milionaire.milionaire.repository.ProfileRepository;
import com.example.milionaire.milionaire.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	//generate private fields
    private final QuestionRepository questionRepository;
    private final ProfileRepository profileRepository;

    //generate constructor
    public QuestionService(QuestionRepository questionRepository, ProfileRepository profileRepository) {
        this.questionRepository = questionRepository;
        this.profileRepository = profileRepository;
    }
    
    //find profile by id
    public List<Question> findByProfileId(Long profileId) {
        return questionRepository.findByProfileId(profileId);
    }
    
    //save all questions to some profile
    public void saveAll(List<Question> questions, Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                            .orElseThrow(() -> new RuntimeException("Profile not found"));

        // delete old questions and add new question fit to some profile
        questionRepository.deleteAll(findByProfileId(profileId));

        for (Question q : questions) {
            q.setProfile(profile);
            questionRepository.save(q);
        }
    }
}
