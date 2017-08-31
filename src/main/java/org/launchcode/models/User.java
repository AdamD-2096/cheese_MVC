package org.launchcode.models;

import org.launchcode.helpers.MDY;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    /*
    *   Fields
    */
    @NotNull
    @Size(min=3, max=20, message = "please keep your username between 3 and 20 characters")
    private String username;
    @NotNull
    @Size(min=8, message = "please enter a valid email")
    private String email;
    @NotNull
    @Size(min=8, message = "Password must be at least 8 characters long")
    private String password;
    private int id;
    private static int nextId = 1000;
    private String date;
    /*
    *   Constructors
    */
    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(){
        this.date = MDY.getMMDDYY();
        this.id = nextId;
        nextId++;
    }
    /*
    *   Getters and Setters
    */
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getId() { return id; }
    private void setId(int id) { this.id = id; }

    public String getDate() { return date; }
    private void setDate(String date) { this.date = date; }

    /*
    *   Instance Methods
    */
}
