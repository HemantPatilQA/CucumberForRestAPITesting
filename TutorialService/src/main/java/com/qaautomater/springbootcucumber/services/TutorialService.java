package com.qaautomater.springbootcucumber.services;

import com.qaautomater.springbootcucumber.entities.Tutorial;
import com.qaautomater.springbootcucumber.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> findById(Long Id) {
        return tutorialRepository.findById(Id);
    }

    public List<Tutorial> findByNameContaining(String name) {
        return tutorialRepository.findByNameContaining(name);
    }
}
