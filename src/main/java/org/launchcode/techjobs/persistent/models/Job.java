package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.List;

//TODO Task 3 Part 2 - have job extend AbstractEntity and remove redundant fields
@Entity
public class Job extends AbstractEntity{

    //TODO Task 3 Part 3 - replace employer with Employer, getter/setter, and right annotation
    @ManyToOne //many jobs can be associated with one employer
    private Employer employer;

    //TODO Task 4 Part 2 - map relationship to skills and update as needed
    @ManyToMany //each job can have many skills, each skill can be associated with many jobs
    private List<Skill> skills;

    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, List someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
