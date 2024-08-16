package com.niit.FavouriteMovieService.service;

import com.niit.FavouriteMovieService.domain.FavouriteMovie;
import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.MovieNotFoundException;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;

import java.util.List;

public interface IFavouriteMovieService {
    User registerUser(User user) throws UserAlreadyExistException;
    User updateUser(User user,String userId) throws UserNotFoundException;


    //New method to delete a user
    void deleteUseronlyFavouriteMovie(String userId,String movieId) throws UserNotFoundException,MovieNotFoundException;

    // new method to saerch a user based on moviename
    List<User> searchUsersByMovieName(String movieName) throws UserNotFoundException;

    //this two feroz
    User saveFavouriteMovieToList(FavouriteMovie favouriteMovie, String userId) throws UserNotFoundException;
    List<FavouriteMovie> getAllFavouriteMoviesFromList(String userId) throws UserNotFoundException;

}
