package com.niit.FavouriteMovieService.service;

import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;
import com.niit.FavouriteMovieService.repository.IFavouriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteMovieServiceImpl implements IFavouriteMovieService{
    IFavouriteMovieRepository iFavouriteMovieRepository;

    @Autowired
    public FavouriteMovieServiceImpl(IFavouriteMovieRepository iFavouriteMovieRepository) {
        this.iFavouriteMovieRepository = iFavouriteMovieRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistException {
        if (iFavouriteMovieRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        User user1=iFavouriteMovieRepository.save(user);
        return user1;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User existingUser=iFavouriteMovieRepository.findById(user.getUserId()).get();
        if (existingUser==null){
            throw new UserNotFoundException();
        }
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            existingUser.setUsername(user.getUsername());
        }
        if(user.getEmail() != null && !user.getEmail().isEmpty()) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPassword() !=null && !user.getPassword().isEmpty()){
            existingUser.setPassword(user.getPassword());
        }
        if (user.getImageUrl() !=null && !user.getImageUrl().isEmpty()){
            existingUser.setImageUrl(user.getImageUrl());
        }

        return iFavouriteMovieRepository.save(existingUser);
    }
}
