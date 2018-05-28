package com.alexbazlinton.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favourites);

    Intent intent = getIntent();
    Movie favouriteMovieToAddToCollection = (Movie) intent.getSerializableExtra("movie");

    ApplicationState applicationState = SharedPreferencesHelper.loadApplicationState(this);

    applicationState.getFavouriteMovies().add(favouriteMovieToAddToCollection);
    SharedPreferencesHelper.saveApplicationState(this, applicationState);

    ArrayList<String> moviesNames = new ArrayList<>();

    for (Movie movie : applicationState.getFavouriteMovies()){
      String title = movie.getTitle();
      moviesNames.add(title);
    }

    ArrayAdapter<String> movieNamesArrayAdapter = new ArrayAdapter<String>(this, R.layout.movies_textview, moviesNames);

    ListView movieNamesListView = findViewById(R.id.favouriteMoviesListViewId);
    movieNamesListView.setAdapter(movieNamesArrayAdapter);


  }
}
