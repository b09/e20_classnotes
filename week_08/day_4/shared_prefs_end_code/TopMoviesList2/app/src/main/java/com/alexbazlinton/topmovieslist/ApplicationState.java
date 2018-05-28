package com.alexbazlinton.topmovieslist;

import java.util.ArrayList;

public class ApplicationState {

  private ArrayList<Movie> favouriteMovies;
  private String userName;



  public ApplicationState(String userName){
    this.userName = userName;
    this.favouriteMovies = new ArrayList<Movie>();
  }


  public ArrayList<Movie> getFavouriteMovies() {
    return favouriteMovies;
  }

  public void setFavouriteMovies(ArrayList<Movie> favouriteMovies) {
    this.favouriteMovies = favouriteMovies;
  }
}
