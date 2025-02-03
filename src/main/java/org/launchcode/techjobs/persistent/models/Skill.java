package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @Size(min = 0, max = 100, message="Must be within 0 and 100 characters in length.")
    public String description;

    public Skill() {};

    public Skill(String description){
        super();
        this.description = description;
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
