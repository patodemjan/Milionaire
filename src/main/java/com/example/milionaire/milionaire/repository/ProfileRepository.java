package com.example.milionaire.milionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.milionaire.milionaire.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {}


