package com.example.milionaire.milionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.milionaire.milionaire.entity.Profile;
//repository for profiles
public interface ProfileRepository extends JpaRepository<Profile, Long> {}


