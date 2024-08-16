package com.niit.FavouriteMovieService.service;

import com.niit.FavouriteMovieService.domain.FavouriteMovie;
import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.MovieNotFoundException;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;
import com.niit.FavouriteMovieService.repository.IFavouriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public User updateUser(User user,String userId) throws UserNotFoundException {
        User existingUser=iFavouriteMovieRepository.findById(userId).get();
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

    @Override
    public void deleteUseronlyFavouriteMovie(String userId, String movieId) throws UserNotFoundException, MovieNotFoundException {
        User existingUser = iFavouriteMovieRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        List<FavouriteMovie> movieDetails = existingUser.getMovieDetails();
        Optional<FavouriteMovie> movieToDelete = movieDetails.stream()
                .filter(movie -> movie.getMovieId().equals(movieId))
                .findFirst();

        if (movieToDelete.isPresent()) {
            movieDetails.remove(movieToDelete.get());
            existingUser.setMovieDetails(movieDetails);
            iFavouriteMovieRepository.save(existingUser);
        } else {
            throw new MovieNotFoundException();
        }
    }


    @Override
    public List<User> searchUsersByMovieName(String movieName) throws UserNotFoundException {
        List<User> users = iFavouriteMovieRepository.findByMovieDetailsMovieName(movieName);
        if (users.isEmpty()) {
            throw new UserNotFoundException();
        }
        return users;
    }

    @Override
    public User saveFavouriteMovieToList(FavouriteMovie favouriteMovie, String userId) throws UserNotFoundException {
        // Save the product to the User
        if(iFavouriteMovieRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = iFavouriteMovieRepository.findByUserId(userId);
        if(user.getMovieDetails() == null)
        {
            user.setMovieDetails(Arrays.asList(favouriteMovie));
        }
        else {
            List<FavouriteMovie> products = user.getMovieDetails();
            products.add(favouriteMovie);
            user.setMovieDetails(products);
        }
        return iFavouriteMovieRepository.save(user);    }

    @Override
    public List<FavouriteMovie> getAllFavouriteMoviesFromList(String userId) throws UserNotFoundException {
        // Get all products from the User list
        if(iFavouriteMovieRepository.findById(userId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return iFavouriteMovieRepository.findById(userId).get().getMovieDetails();
    }

}





