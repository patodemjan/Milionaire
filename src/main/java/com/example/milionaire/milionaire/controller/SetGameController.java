package com.example.milionaire.milionaire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.milionaire.milionaire.entity.Question;
import com.example.milionaire.milionaire.form.GameForm;
import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.service.ProfileService;
import com.example.milionaire.milionaire.service.QuestionService;

@Controller
public class SetGameController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/setgame")
    public String showSetGamePage(@RequestParam(value = "profileId", required = false) Long profileId, Model model) {
        List<Profile> profiles = profileService.findAll();
        model.addAttribute("profiles", profiles);

        GameForm gameForm = new GameForm();

        if (profileId != null) {
            gameForm.setProfileId(profileId);

            List<Question> questions = questionService.findByProfileId(profileId);
            if (questions == null || questions.isEmpty()) {
                Profile profile = profileService.findById(profileId);
                int count = (profile != null) ? profile.getQuestionCount() : 5;

                List<Question> emptyQuestions = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    emptyQuestions.add(new Question());
                }
                gameForm.setQuestions(emptyQuestions);
            } else {
                gameForm.setQuestions(questions);
            }
        } else {
            // Ak profil nie je vybraný, zobraz 5 prázdnych otázok
            List<Question> emptyQuestions = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                emptyQuestions.add(new Question());
            }
            gameForm.setQuestions(emptyQuestions);
        }

        model.addAttribute("gameForm", gameForm);
        return "setgame";
    }

    @PostMapping("/setgame")
    public String saveQuestions(@ModelAttribute GameForm gameForm) {
        questionService.saveAll(gameForm.getQuestions(), gameForm.getProfileId());
        return "redirect:/setgame?profileId=" + gameForm.getProfileId();
    }
}
