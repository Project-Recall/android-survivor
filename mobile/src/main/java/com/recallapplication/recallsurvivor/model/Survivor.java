package com.recallapplication.recallsurvivor.model;

public class Survivor
{

    private String firstName, lastName, email, password, confirmPassword;
    private int memoryRating;

    public Survivor()
    {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getMemoryRating() {
        return memoryRating;
    }

    public void setMemoryRating(int memoryRating) {
        this.memoryRating = memoryRating;
    }
}
