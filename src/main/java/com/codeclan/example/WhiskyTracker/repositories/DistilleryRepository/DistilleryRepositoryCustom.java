package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import java.util.List;

public interface DistilleryRepositoryCustom {

    List<Distillery> findByRegion(String region);

    List<Distillery> findByWhiskiesAge(int age);
}
