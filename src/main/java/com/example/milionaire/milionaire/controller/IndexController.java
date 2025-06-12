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

	//generate private fields
	private final ProfileRepository profileRepository;
    private final QuestionService questionService;

    //generate constructor
    public IndexController(ProfileRepository profileRepository, QuestionService questionService) {
        this.profileRepository = profileRepository;
        this.questionService = questionService;
    }

    //mapping for homepage
    @GetMapping({"/", "/home", "/index"})
    public String homePage(Model model) {
        return "index";
    }

    //mapping for new game

    @GetMapping("/newgame")
    public String newGamePage(@RequestParam(value = "profileId", required = false) Long profileId, Model model) {
        List<Profile> profiles = profileRepository.findAll();
        model.addAttribute("profiles", profiles);

        if (profileId != null) {
            List<Question> questions = questionService.findByProfileId(profileId);
            // random questions
            java.util.Collections.shuffle(questions);
            model.addAttribute("selectedProfileId", profileId);
            model.addAttribute("questions", questions);
        }

        return "newgame";
    }
	
    //mapping for set game

	@RequestMapping("/setgame")
	public String setGamePage(Model model) {
	    model.addAttribute("gameForm", new GameForm());
	    model.addAttribute("profiles", profileRepository.findAll()); // ak používaš výber profilov
	    return "setgame";
	}
    
    //mapping for exit

    @RequestMapping("/exit")
    public String exit(Model model) {
        return "exit";
    }
    
    //mapping for about this game

    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }
    
    //mapping for create game

    @RequestMapping("/createprofile")
    public String createprofile(Model model) {
        return "createprofile";
    }
    


}
