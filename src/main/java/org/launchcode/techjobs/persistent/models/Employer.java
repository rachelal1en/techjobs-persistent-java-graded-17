package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Cannot leave blank.")
    @Size(min = 0, max = 100, message="Must be within 0 and 100 characters in length.")
    public String location;

    public Employer() {};

    public Employer(String location) {
        super();
        this.location = location;
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
