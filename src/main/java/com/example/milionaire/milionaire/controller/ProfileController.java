package com.example.milionaire.milionaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.repository.ProfileRepository;

@Controller
public class ProfileController {

	//define private field
    private final ProfileRepository profileRepository;

    //generate constructor
    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // view of create profile with table
    @GetMapping("/createprofile")
    public String showCreateProfileForm(Model model) {
        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepository.findAll());
        return "createprofile"; // súbor createprofile.html
    }

    // save profile + createprofile.html s updated table
    @PostMapping("/createprofile")
    public String submitCreateProfile(@ModelAttribute Profile profile, Model model) {
        if (profile.getQuestionCount() > 30) {
            profile.setQuestionCount(30);
        }

        profileRepository.save(profile);

        model.addAttribute("profile", new Profile());
        model.addAttribute("profiles", profileRepository.findAll());
        return "createprofile";
    }

    // delete profile by id and redirect to createprofile.html
    @PostMapping("/deleteprofile/{id}")
    public String deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
        return "redirect:/createprofile";
    }
}
