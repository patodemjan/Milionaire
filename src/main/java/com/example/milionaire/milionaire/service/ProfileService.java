package com.example.milionaire.milionaire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.repository.ProfileRepository;

@Service
public class ProfileService {
	
	//generate private field
    private final ProfileRepository profileRepository;

    //generate constructors
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // return all profiles
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    // find profile by id
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    // save or update profile
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    // delete profile by id
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
