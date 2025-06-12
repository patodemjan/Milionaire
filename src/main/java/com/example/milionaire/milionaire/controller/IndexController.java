package com.example.milionaire.milionaire.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.entity.Question;
import com.example.milionaire.milionaire.form.GameForm;
import com.example.milionaire.milionaire.repository.ProfileRepository;
import com.example.milionaire.milionaire.service.QuestionService;

@Controller
public class IndexController {

	private final ProfileRepository profileRepository;
    private final QuestionService questionService;

    public IndexController(ProfileRepository profileRepository, QuestionService questionService) {
        this.profileRepository = profileRepository;
        this.questionService = questionService;
    }

    @GetMapping({"/", "/home", "/index"})
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/newgame")
    public String newGamePage(@RequestParam(value = "profileId", required = false) Long profileId, Model model) {
        List<Profile> profiles = profileRepository.findAll();
        model.addAttribute("profiles", profiles);

        if (profileId != null) {
            List<Question> questions = questionService.findByProfileId(profileId);
            // Náhodné preusporiadanie otázok
            java.util.Collections.shuffle(questions);
            model.addAttribute("selectedProfileId", profileId);
            model.addAttribute("questions", questions);
        }

        return "newgame";
    }
	
	@RequestMapping("/setgame")
	public String setGamePage(Model model) {
	    model.addAttribute("gameForm", new GameForm());
	    model.addAttribute("profiles", profileRepository.findAll()); // ak používaš výber profilov
	    return "setgame";
	}
    
    @RequestMapping("/exit")
    public String exit(Model model) {
        return "exit";
    }
    
    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }
    
    @RequestMapping("/createprofile")
    public String createprofile(Model model) {
        return "createprofile";
    }
    


}
