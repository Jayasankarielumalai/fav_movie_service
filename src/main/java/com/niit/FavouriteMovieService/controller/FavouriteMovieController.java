package com.niit.FavouriteMovieService.controller;

import com.niit.FavouriteMovieService.domain.User;
import com.niit.FavouriteMovieService.exception.UserAlreadyExistException;
import com.niit.FavouriteMovieService.exception.UserNotFoundException;
import com.niit.FavouriteMovieService.service.IFavouriteMovieService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class FavouriteMovieController {
    ResponseEntity responseEntity;
    IFavouriteMovieService iFavouriteMovieService;
@Autowired
    public FavouriteMovieController(IFavouriteMovieService iFavouriteMovieService) {
        this.iFavouriteMovieService = iFavouriteMovieService;
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) throws UserAlreadyExistException{
    try {
        User registeredUser=iFavouriteMovieService.registerUser(user);
        responseEntity=new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    } catch (UserAlreadyExistException e) {
        throw new UserAlreadyExistException();
    } catch (Exception e){
        responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
    }

    @PutMapping("/user/update")
    public ResponseEntity updateUser(@RequestBody User user, HttpServletRequest request) throws UserNotFoundException{
    try{
        User updatedUser=iFavouriteMovieService.updateUser(user,getUserIdFromClaims(request));
        responseEntity=new ResponseEntity<>(updatedUser,HttpStatus.OK);
    } catch (UserNotFoundException e) {
        throw new UserNotFoundException();
    } catch (Exception e){
        responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
    }

    //New method to delete a user
    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        try {
            iFavouriteMovieService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    //new method to serach a user
    @GetMapping("/search/{movieName}")
    public ResponseEntity<?> searchUsersByMovieName(@PathVariable String movieName) {
        try {
            List<User> users = iFavouriteMovieService.searchUsersByMovieName(movieName);
            return ResponseEntity.ok(users);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body("No users found with the movie name: " + movieName);
        }
    }


    private String getUserIdFromClaims(HttpServletRequest request){
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("User ID from claims :: " + claims.getSubject());
        return claims.getSubject();
    }
}
