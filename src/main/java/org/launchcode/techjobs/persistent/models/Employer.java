package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity //mapped to a table & persistent
public class Employer extends AbstractEntity {

    //TODO Task 2 Part 2 - Add location field with validation and public accessor methods plus entity designation
    @NotBlank(message = "Required field.")
    @Size(min = 0, max = 100, message="Must be within 0 and 100 characters in length.")
    public String location;

    //TODO Task 3 Part 1 - add jobs empty array list
    @OneToMany //one employer to many jobs
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();


    public Employer(String location) {
        this.location = location;
    }
    //required default constructor
    public Employer() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
