package com.example.milionaire.milionaire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.milionaire.milionaire.entity.Profile;
import com.example.milionaire.milionaire.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // Vráti všetky profily
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    // Nájde profil podľa ID
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    // Uloží alebo aktualizuje profil
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    // Odstráni profil podľa ID
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
