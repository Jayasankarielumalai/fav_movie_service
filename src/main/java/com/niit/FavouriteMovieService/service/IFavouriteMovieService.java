package com.niit.FavouriteMovieService.service;

import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;

import java.util.List;

public interface IFavouriteMovieService {
    User registerUser(User user) throws UserAlreadyExistException;
    User updateUser(User user,String userId) throws UserNotFoundException;


    //New method to delete a user
    void deleteUser(String userId) throws UserNotFoundException;

    // new method to saerch a user based on moviename
    List<User> searchUsersByMovieName(String movieName) throws UserNotFoundException;

}
