package org.launchcode.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
public class Cheese {

    @NotNull
    @Size(min=3, max=20, message = "please keep the cheese name between 3 and 20 characters")
    private String name;
    @NotNull
    @Size(min=2, message = "please describe your cheese")
    private String description;
    @NotNull
    @Range(min=1, max=5, message = "please rate between 1 and 5 stars")
    private int rating;
    @NotNull
    private CheeseType type;
    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }
    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() { return type; }
    public void setType(CheeseType type) { this.type = type; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
