package com.niit.FavouriteMovieService.service;

import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;

public interface IFavouriteMovieService {
    User registerUser(User user) throws UserAlreadyExistException;
    User updateUser(User user) throws UserNotFoundException;
}
