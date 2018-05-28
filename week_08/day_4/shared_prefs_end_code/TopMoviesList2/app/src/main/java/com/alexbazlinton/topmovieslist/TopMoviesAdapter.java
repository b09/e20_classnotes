package com.alexbazlinton.topmovieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TopMoviesAdapter extends ArrayAdapter<Movie> {

  public TopMoviesAdapter(Context context, ArrayList<Movie> movies){
    super(context, 0, movies);
  }

  @Override
  public View getView(int position, View listItemView, ViewGroup parent){
    if (listItemView == null){
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list_item, parent, false );
    }

    Movie currentMovie = getItem(position);

    TextView rankingTextView = listItemView.findViewById(R.id.rankingTextViewId);
    rankingTextView.setText(currentMovie.getRanking().toString());

    TextView titleTextView = listItemView.findViewById(R.id.titleTextViewId);
    titleTextView.setText(currentMovie.getTitle());

    TextView yearTextView = listItemView.findViewById(R.id.yearTextViewId);
    yearTextView.setText(currentMovie.getYear().toString());

    listItemView.setTag(currentMovie);

    

    return listItemView;

  }


}
