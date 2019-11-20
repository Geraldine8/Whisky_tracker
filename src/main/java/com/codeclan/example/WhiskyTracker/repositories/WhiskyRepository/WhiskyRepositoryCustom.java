package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findByYear (int year);

    List<Whisky> findWhiskiesFromADistilleryOfASpecificAge(Long id, int age);

    List<Whisky> findWhiskiesFromParticularRegion(String region);

}
