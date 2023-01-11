package com.qaautomater.springbootcucumber.entities;


import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tutorial")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    private String description;

    private boolean published;
}
