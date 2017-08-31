package org.launchcode.models;

public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("FAKE");

    private final String name;

    CheeseType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
