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

    private final QuestionRepository questionRepository;
    private final ProfileRepository profileRepository;

    public QuestionService(QuestionRepository questionRepository, ProfileRepository profileRepository) {
        this.questionRepository = questionRepository;
        this.profileRepository = profileRepository;
    }

    public List<Question> findByProfileId(Long profileId) {
        return questionRepository.findByProfileId(profileId);
    }

    public void saveAll(List<Question> questions, Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                            .orElseThrow(() -> new RuntimeException("Profile not found"));

        // Napríklad vymaž staré otázky k profilu a ulož nové
        questionRepository.deleteAll(findByProfileId(profileId));

        for (Question q : questions) {
            q.setProfile(profile);
            questionRepository.save(q);
        }
    }
}
