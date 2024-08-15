package com.niit.FavouriteMovieService.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private  String email;
    private Long phoneNumber;
    private FavouriteMovie movieDetails;

    public User(String userId, String firstname, String lastname, String username, String password, String email, Long phoneNumber, FavouriteMovie movieDetails) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.movieDetails = movieDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", movieDetails=" + movieDetails +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public FavouriteMovie getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(FavouriteMovie movieDetails) {
        this.movieDetails = movieDetails;
    }
}
