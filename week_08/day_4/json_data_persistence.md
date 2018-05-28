# Saving JSON to SharedPreferences

## Learning Objectives

  - Know what data persistence options there are in Android
  - Understand serialization and deserialization
  - Be able to store JSON in SharedPreferences

### Introduction

Android offers us several options for data persistence. The method that you choose depends on your specific needs, such as whether the data should be private to your application or accessible to other applications (and the user) and how much space your data requires.

The methods are:

* Shared Preferences - store private primitive data in key-value pairs.

* Internal Storage - store private data on the device memory.

* External Storage - store public data on the shared external storage e.g. SD card .

* SQLite Databases - store structured data in a private database. Android has a new persistence library called Room which harnesses SQLite - https://developer.android.com/topic/libraries/architecture/room 

* Network Connection - store data on the web with your own network server.

We're going to use SharedPreferences which is a simple store of key/value pairs, a bit like a hash. 

Often, you'll just want to store simple key/value pairs such as user IDs or session variables. But it's also possible to store JSON in SharedPreferences which gives us a way of storing complex data structures including ArrayLists for example.

### Why Are We Doing This?

We're doing this because becoming familiar with JSON is a very useful skill to have as a programmer, and not just in the world of Java/Android. Also, it could be very useful when it comes to building an app for your project.

### I Do

Let's build on our TopMoviesList. So far we are passing a Movie object through to our FavouritesActivity with an Intent via the `onListItemClick` method in our TopMoviesACtivity  and displaying the title in a TextView.

### You Do

> TASK:

```
1. Create a new activity called FavouritesActivity
2. Update the onListItemClick method, adding a new Intent and add the Movie object as an extra
3. Update the onListItemClick method to start the FavouritesActivity 
```

> SOLUTION:

```java
//TopMoviesActivity

public void onListItemClick(View listItem) {
    Movie movie = (Movie) listItem.getTag();
    Log.d("Movie Title: ", movie.getTitle());

    Log.d("Selected Movie: ", movie.getTitle());

    Intent intent = new Intent(this, FavouritesActivity.class); // UPDATED
    intent.putExtra("movie", movie);

    startActivity(intent);
}

```

Let's run it in our emulator. We should be taken to a new blank activity (FavouritesActivity) when we click on a movie item.


### I Do: Using Shared Preferences & JSON

Shared preferences use the ```SharedPreferences``` class. 

This class gives us a general framework that lets us save and retrieve persistent key-value pairs of primitive data types. We can use SharedPreferences to save any primitive data: booleans, floats, ints, longs, and Strings. This data will persist across user sessions (even if you kill your app).

JSON is a common way to store data. And it's going to be useful for us because we can store JSON as a String. Therefore we can store a JSON string (which represents a Java object) in SharedPreferences.

We want to store our favourite Movie. But first, we'll have to convert the Movie to a String and for that, we'll need to use the GSON library.

GSON: A Java serialization/deserialization library that can convert Java Objects into JSON and back.

> NOTE: This is not quite the same as having a class in Java implement Serializable.

Let's add it to our Gradle file dependencies.

```java
// build.gradle (Module: app)

implementation 'com.google.code.gson:gson:2.3.1' // NEW

```
> you could try and use a later version Gson here ^


### We Do: Implementing SharedPreferences

In our FavouritesActivity let's get the existing favourite from SharedPreferences.

Here's our plan:

> DRAW ON BOARD -

1. Get the existing favourite from SharedPreferences
2. Grab hold of the new favourite Movie from the Intent
3. Display the favourite Movie in some way
4. Save the new favourite Movie back to SharedPreferences
5. Expand our app to maintain a list of favourite Movies and display them


### Get the existing favourite from SharedPreferences

We'll have to import SharedPreferences. Also, we'll have to create a string resource called ```preference_file_key```. We'll give it the value "FAVOURITES".

We can think of this key almost as the name of our database. 

Remember SharedPreferences works as a key/value system. So we're going to attempt to get the value associated with the key "MyFavouriteMovie". The second argument for the getString method is what we'll get back if "MyFavouriteMovie" doesn't yet exist. 

So favouriteMovies is now going to be a reference to a String representation of the favourite Movie object. 

```java
//FavouritesActivity
SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
String favouriteMovie = sharedPref.getString("MyFavouriteMovie", "{}");
Log.d("Favourites String", favouriteMovie);
```

> Remember here: we tried to use null and "" as default values for the Movie and it broke `Log.d`. Here I've changed it the the JSON representation of an empty object.

Let's run it and see what our Favourite String looks like logged out.

### Turn this JSON representation into a Movie object

First we need to deserialize the existing favourite Movie using the GSON library.

> We need a reference to the class in order to tell Gson what type of thing that the JSON should be turned into.

```java
//FavouritesActivity
Gson gson = new Gson();
Movie myFavourite = gson.fromJson(favouriteMovie, Movie.class);
Log.d("myFavourite", myFavourite.toString());
```

At this point myFavourite is a Movie object. So now, we can add the Movie we passed from the main activity. Nice!

```java
//FavouritesActivity
Movie newFavourite = (Movie) getIntent().getSerializableExtra("movie");
Log.d("myFavourite", myFavourite.toString());
```


Let's run it and see what our logged out Movie message looks like.

> Should look something like:

```
D/myFavourite: com.codeclan.topmovieslist.Movie@1dbad3a
```


### We Do: Save the new favourite back to SharedPreferences

To add a key/value pair to SharedPreferences we need to get a handle to and Editor object and ask GSON to serialize our Movie using the toJson method.

```java
//FavouritesActivity

//Save new fave to SharedPref
SharedPreferences.Editor editor = sharedPref.edit();

editor.putString("MyFavourite", gson.toJson(newFavourite));
editor.apply();


```

### I Do: Abstract away the SharedPreferences, Gson functionality and Escapsulation of the Application State.

We are doing a lot of work in out FavouritesActivity `onCreate` method. As soon as we do this in another Activity our code is not going to be very DRY. To get around this we could create a `SharedPreferencesHelper` to handle the saving (persisting) and loading of our application state. We could compare this to our `SqlRunner` class in Ruby. It will have some static methods (aka class methods) to achieve our peristence. We won't instantiate a new one each time we need to use it.

#### The Bigger picture

We have seen in Android that Activities have a Lifecycle and lots of methods we can override to control how respond when our is created / started / stopped / resumed etc.

https://developer.android.com/guide/components/activities/activity-lifecycle

We'd like it if our app was able to maintain it's state (in our case say an ArrayList of our favourite movies, but it could be anything - the user's name, whether they've gone through the first-run tutorial etc). And we'd like it to maintain it's state whatever happens - if the app is killed when if a call comes in... To make our app robust we do things like -

- When an Activity is created get our ApplicationState from SharedPreferences
- Updated the state with any requested changes then persist (save) it back to SharedPreferences
- React when our data is at risk - the user powers down the device say - and persist any changes we want the user not to lose

To achieve this effectively we can wrap our state up in an object (below called ApplicationState). We now have one object that encapsulates our whole application state and that can be loaded and persisted back and forth to SharedPreferences. As our app expands we can just simply add new properties. And using our `SharedPreferencesHelper` we are keeping the Single Responsibility Principle in mind. Letting each part of our program concern itself with particular job.

### You Do:

> - Create the classes below in your project (SharedPreferencesHelper, ApplicationState)
> - With your neighbour/s discuss the code -
> 	- how it works
> 	- how you might leverage it 
> 	- what you are unclear on


```java

// SharedPreferencesHelper.java

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesHelper {

  public static void saveApplicationState(Context context, ApplicationState state){

    SharedPreferences.Editor editor = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE).edit();
    Gson gson = new Gson();
    String json = gson.toJson(state);
    editor.putString("APPLICATION_STATE", json);
    editor.apply();
  }

  public static ApplicationState loadApplicationState(Context context){
    SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    Gson gson = new Gson();
    ApplicationState applicationState = gson.fromJson(sharedPreferences.getString("APPLICATION_STATE", "{}"), ApplicationState.class );
    return applicationState;
  }
}
```
---

```java
// ApplicationState.java

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
```

### We Do

Let's see how we might use this code in our project -

```java
	// FavouritesActivity.java
	...
	Intent intent = getIntent();
	Movie favouriteMovieToAddToCollection = (Movie) intent.getSerializableExtra("movie");
	
	ApplicationState applicationState = SharedPreferencesHelper.loadApplicationState(this);
	applicationState.getFavouriteMovies().add(favouriteMovieToAddToCollection);
	SharedPreferencesHelper.saveApplicationState(this, applicationState);
```

Here we -

- Already have our movie to favorite from the Intent
- Load our existing `ApplicationState`
- Add the movie we were passed through from `TopMoviesActivity` to the `ApplicationState`
- Persist the changes

### I Do:

In the end code on in the classnotes I've added some extra functionality -

```java
    // TopMoviesActivity.java
    
    ApplicationState applicationState = SharedPreferencesHelper.loadApplicationState(this);

    // If this is first run of our app we should new up our ApplicationState
    // If we don't do this Gson interprets the default value of APPLICATION_STATE -> "{}"
    // as object with null for its instance variables
    if (applicationState.getFavouriteMovies() == null){
      applicationState = new ApplicationState("NONAME");
      SharedPreferencesHelper.saveApplicationState(this, applicationState);
    }
```

In our `SharedPreferencesHelper` this line could cause use trouble -

```java
ApplicationState applicationState = gson.fromJson(sharedPreferences.getString("APPLICATION_STATE", "{}"), ApplicationState.class );
```

As per the code comments. When we run our app for the very first time we have nothing in SharedPreferences. We set a default value to be returned in the 2nd argument to `sharedPreferences.getString` this is the JSON for an empty object `{}`. This has the side-effect that our very first ApplicationState will look like this -

```java
applicationState.favouriteMovies == null
applicationState.userName == null
```

If we try `favouriteMovies.add(movieToAddGoesHere)` we'll be calling `.add` on `null` and get our dreaded `NullPointerException`. The null check here prevents this potential blow-up. We initialize our state when we detect our `favouriteMovies` are null - ie it is the very first run of our app.


### You Do

- Investigate a more elegant solution to this issue. This method looks promising -

`sharedPreferences.contains(String key);`

https://developer.android.com/reference/android/content/SharedPreferences.html#contains(java.lang.String)

### Finally 

In the end code I've also added a ListView, and simple ArrayAdapter to display the current contents of `favouriteMovies`

### Summary

Have we hit our learning objectives?

- Know what data persistence options there are in Android
- Understand serialization and deserialization
- Be able to store JSON in SharedPreferences
