package com.example.mynotes.retrofit;

import com.google.gson.annotations.SerializedName;

public class tokenResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("firstName")
    private int firstName;

    @SerializedName("lastName")
    private int lastName;

    @SerializedName("email")
    private int email;

    @SerializedName("jwtToken")
    private int jwtToken;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(int jwtToken) {
        this.jwtToken = jwtToken;
    }
}
