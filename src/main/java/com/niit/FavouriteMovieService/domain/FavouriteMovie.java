package com.niit.FavouriteMovieService.domain;

import java.util.List;
public class FavouriteMovie {
    private String movieId;
    private String movieName;
    private Double rating;
    private String genre;
    private String yearOfRelease;
    private List<String> language;
    private String duration;  //1hr 30mins
    private List<String> cast;
    private String movieSynopsis;
    private String moviePosterUrl;
    private Boolean isFavorite;

    public FavouriteMovie(String movieId, String movieName, Double rating, String genre, String yearOfRelease, List<String> language, String duration, List<String> cast, String movieSynopsis, String moviePosterUrl, Boolean isFavorite) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.language = language;
        this.duration = duration;
        this.cast = cast;
        this.movieSynopsis = movieSynopsis;
        this.moviePosterUrl = moviePosterUrl;
        this.isFavorite = isFavorite;
    }

    @Override
    public String toString() {
        return "FavouriteMovie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", language=" + language +
                ", duration='" + duration + '\'' +
                ", cast=" + cast +
                ", movieSynopsis='" + movieSynopsis + '\'' +
                ", moviePosterUrl='" + moviePosterUrl + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}
