package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

//TODO Task 2 Part 1 - label parent and add annotations to ID and name
@MappedSuperclass //provides mapping info for subclasses
public abstract class AbstractEntity {

    @Id //primary key
    @GeneratedValue
    private int id;

    @NotBlank(message = "Required field.") //Not null or empty
    @Size(min = 0, max = 100, message="Must be within 0 and 100 characters in length.")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
