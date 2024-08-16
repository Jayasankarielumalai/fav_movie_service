package com.niit.FavouriteMovieService.repository;

import com.niit.FavouriteMovieService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IFavouriteMovieRepository extends MongoRepository<User,String> {
    List<User> findByMovieDetailsMovieName(String movieName);//based moviename search for all movoies
}
