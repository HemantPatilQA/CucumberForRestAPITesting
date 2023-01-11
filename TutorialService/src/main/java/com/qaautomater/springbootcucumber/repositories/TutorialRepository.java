package com.qaautomater.springbootcucumber.repositories;

import com.qaautomater.springbootcucumber.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByNameContaining(String name);
}
