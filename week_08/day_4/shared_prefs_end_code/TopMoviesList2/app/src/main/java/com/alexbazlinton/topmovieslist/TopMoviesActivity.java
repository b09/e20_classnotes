package com.alexbazlinton.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TopMoviesActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_movies);

    ApplicationState applicationState = SharedPreferencesHelper.loadApplicationState(this);

    // If this is first run of our app we should new up our ApplicationState
    // If we don't do this Gson interprets the default value of APPLICATION_STATE -> "{}"
    // as object with null for its instance variables
    if (applicationState.getFavouriteMovies() == null){
      applicationState = new ApplicationState("NONAME");
      SharedPreferencesHelper.saveApplicationState(this, applicationState);
    }

    TopMovies topMovies = new TopMovies();
    ArrayList<Movie> movieList = topMovies.getList();

    TopMoviesAdapter topMoviesAdapter = new TopMoviesAdapter(this, movieList);

    ListView moviesListView = findViewById(R.id.moviesListViewId);
    moviesListView.setAdapter(topMoviesAdapter);

  }

  public void onListItemClick(View listItem){
    Movie movie = (Movie) listItem.getTag();
    Log.d("Movie Title: ", movie.getTitle());

    Intent intent = new Intent(this, FavouritesActivity.class);
    intent.putExtra("movie", movie);
    startActivity(intent);


  }
}
