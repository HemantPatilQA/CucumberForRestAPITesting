package com.qaautomater.springbootcucumber.controllers;

import com.qaautomater.springbootcucumber.entities.Tutorial;
import com.qaautomater.springbootcucumber.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
        Tutorial tutorial1 = tutorialService.save(tutorial);
        return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(){
        return new ResponseEntity<>(tutorialService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") Long Id){
        Optional<Tutorial> tutorial = tutorialService.findById(Id);
        return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
    }

    @GetMapping("/tutorialsbyname")
    public ResponseEntity<List<Tutorial>> getTutorialByNameContaining(@RequestParam String name){
        return new ResponseEntity<>(tutorialService.findByNameContaining(name), HttpStatus.OK);
    }
}
