# Activities and Intents

## Learning Objectives

* Understand what an activity is
* Be able to add a new activity to an app
* Understand what an intent is
* Be able to to pass data between activities using intents


## Requirements 

- A working end-point from Monday's EightBall lesson. There is one in the classnotes if you don't https://github.com/codeclan/e20_classnotes/tree/master/week_08/day_1/. Please make sure you have it successfully running before you head home. (remember Build > Clean Project is often your friend :)

## Goal

- To expand our EightBall app to use multiple Activites, using Intents to pass data between them.

## Activities and Intents
So far we have one 'page' or 'activity' in our app and our screen is starting to look a little 'busy'. Wouldn't it be be nice if we could enter our question and then, rather than the answer being displayed in the same screen, we were taken to a new screen which displayed the answer.

So how do we do this?

As we said earlier, Android has this idea of "activities" and "intents". It is these concepts we are going to make use of.

## Activities

We will start by looking at activities. An Activity is basically an individual screen in your app which is responsible for drawing it's components. It controls particular screen of information. In our ```EightBallActivity``` App we currently only have one Activity called ```EightBallActivity```. As we want a new screen to be displayed when we hit the button then we need to add another activity.

As this new screen is going to display the answer the computer, we can call this Activity ```AnswerActivity```.

## Setting up a new activity

Just like we did before, we want to add a new activity to our app.

```
(Make sure the project pane is showing - cmd + 1)
Right click app > New > Activity > Empty Activity
Change Activity Name to "AnswerActivity"
Make sure "Generate Layout File" is checked
Make sure the Layout Name is activity_answer
Make sure that Backwards Compatibility is checked
Leave the other settings unchanged and click Finish
```

Android should create two files:

- `app/java/com.example.eightball/AnswerActivity.java`
- `app/res/layout/activity_answer.xml`

...And it should edit one file:

- `app/manifests/AndroidManifest.xml`

## Manifest

Take a look at AndroidManifest.xml. Notice that the following has been added under ```<application>```:

```xml
<!-- AndroidManifest.xml -->

<activity android:name=".AnswerActivity"></activity>
```

This tells Android that our new activity exists! We need to make a couple of small changes to our manifest.

```xml
<!-- AndroidManifest.xml -->

<activity
    android:name=".AnswerActivity"
    android:label="@string/answer_activity_title"
    android:parentActivityName=".EightBallActivity">  
</activity>
```

Firstly, we're adding the activity's title, using android:label.

- If we click on `@string/answer_activity_title` and press `alt-Enter` we see an option to `Create string value resourse` use this shortcut, or edit `strings.xml` directly to give the Activity a sensible name.

Secondly, we're setting the ```android:parentActivityName```. 

This activity - `AnswerActivity` - is started by a button click on another activity. We want to be able to go back to the previous activity when we click the 'back' arrow at the top of the screen. 

This previous activity is called the ***Parent*** activity. 

We therefore need to let the manifest know which activity is the parent activity. We do this by using the ```android:parentActivityName``` attribute, and setting the value to the parent activity's name.

### activity_answer.xml

We should have an empty layout file to use for our new activity. It comes by default with a `ConstraintLayout` ready to add in our other controls.

### AnswerActivity.java

Finally, we have our boilerplate java that should hook in to the ```onCreate()``` method and load our layout. This should be the same as our previous activity:

```java
//AnswerActivity.java

public class AnswerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }
}
```

### Move textView to new activity

We want our new activity to include the TextView which is currently in ```activity_main.xml```. We can do this by doing the following:

* In `activity_answer.xml`, add a new `TextView` control, giving it the id `answerTextView`, and making the `Text` attribute blank.

* In `activity_eight_ball.xml`, delete the `TextView` control.

In ```AnswerActivity.java``` lets add the textView control as we did in the original view, so the class needs to include the following variable:

```java
//AnswerActivity.java

private TextView answerTextView;                                   
```

In the ```onCreate``` method, we can assign to these variables as we did before using the ```findViewById``` method, so can add the following to the ```onCreate``` method:

```java
//AnswerActivity.java

    public class AnswerActivity extends AppCompatActivity {
    
    	private TextView answerTextView; 

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d("EightBall:", "AnswerActivity.onCreateCalled");
            setContentView(R.layout.answer_activity);
            
            answerTextView = findViewById(R.id.answerTextView); // <-- added line
        }
    }
```

We can now go back to the ```EightBallActivity.java``` file and delete **ALL** references to ```answerTextView ``` - we won't be showing the answer on our `MainActivity`.

So we are now ready to try running the App, so try running the app and see what happens.

- Possibly your constraints will need tweaking if anything was constrained by the now removed `answerTextView`

You'll notice that all we have on our screen is our EditText control and our shake button. Try entering text and clicking submit. What happens? NOTHING.

If you go to our log you should see a log message stating what text was entered. But we want to go to a new screen which shows our answer.

How do we do this? How do we pass the answer to our question to a new screen so that it can be displayed?

First of all, we need to start the new Activity we wish to run, in our case the ```AnswerActivity``` activity.

The simplest way for one activity (in our case ```EightBallActivity```) to start another activity (```AnswerActivity```) is with the ```startActivity``` method:

```java
startActivity(Intent intent)
```

You might think that ```startActivity``` is a static method you call on the ```Activity``` subclass when you want to start a new activity but when we call ```startActivity``` this call is actually sent to the OS, in particular, to a part of the OS called the ```ActivityManager```. When the OS receives the call to ```startActivity``` the ```ActivityManager``` creates an instance of the ```Activity``` and then calls its ```onCreate``` method.

So how does the ```ActivityManager``` know which ```Activity``` to start? That information is stored in the ```Intent``` parameter.

![Imgur](https://i.imgur.com/orQSw5A.png)

## Intents

So what are intents?

As we (briefly) mentioned before, intents sit between both the OS and activities, giving the OS actions to do and giving back information to activities but also sit in between activities passing around information.

Intents are actually objects which components can use to communicate with the OS. So far, the only component you have seen is the activity, but there are others, such as services, broadcast receivers and context providers.

Intents are multi-purpose communication tools and the ```Intent``` class provides us with different constructors depending on what we are using the intent for.

In our case, we are using an intent to tell the ```ActivityManager``` which activity we want to start, so we need to call the following constructor

```java
    public Intent(Context packageContext, Class<?> cls)
```

The ```Class``` argument specifies the activity class that the  ```ActivityManager``` should start. In our case this is our AnswerActivity class.
The ```Context``` argument tells the ```ActivityManager``` which application package the activity class can be found in. In this case, this is the ```EightBall``` package.

So, in our ```onClick``` method in ```EightBallActivity.java```, let's create an Intent that includes the ```AnswerActivity``` class:

```java
//EightBallActivity.java

  Intent intent = new Intent(this, AnswerActivity.class);
```

Immediately after this we can call ```startActivity```, passing it our newly created intent:

```java
//EightBallActivty.java

    startActivity(intent);
```

So our ```onClick``` method should now look something like this:

```java
//EightBallActivity.java

public void onShakeButtonClick(View view) {
		
	AnswerProvider answerProvider = new AnswerProvider();
	EightBall eightBall = new EightBall(answerProvider);
	String randomAnswer = eightBall.randomAnswer();

	String question = questionEditText.getText().toString();
	Log.d(getClass().toString(), "The question asked was" + question);

	Intent intent = new Intent(this, AnswerActivity.class);
	startActivity(intent);
}

```

Now try running the app? Try entering some text and clicking on the shake button - what do you see?

At the moment, when you click the button, you are taken to a new screen which shows the TextView (well strictly speaking it will be empty, and so pretty invisibile :p), but it does not contain the answer to our question, which we would like it to do.

So what do we have to do to pass information to an activity, and to get an activity to display that information?

## Passing Data Between Activities

Android allows us to pass a value as an ***extra*** on an ```Intent``` passed into ```startActivity```. The OS passes on the intent to the receiving activity, which can then access the extras and retrieve the data

An extra is structured as a key-value pair (like in a HashMap). In our case, we want to pass the text for the 'randomAnswer' to our question.

To add an extra to an intent, we use ```Intent.putExtra(...)```. ```putExtra``` takes two arguments: the first is a string, for the key, and the second is the value to be passed. In our case, we want to pass the string value of our ```randomAnswer``` variable for the answer, so we will use "randomAnswer" for the key and our ```randomAnswer``` string variable for the value i.e:

```java
//EightBallActivity.java

    intent.putExtra("randomAnswer", randomAnswer);
```

This line needs to go after we call the constructor for the intent, but ***BEFORE*** the call to ```startActivity``` e.g.:

```java
//EightBallActivity.java

public void onShakeButtonClick(View view) {
		
	AnswerProvider answerProvider = new AnswerProvider();
	EightBall eightBall = new EightBall(answerProvider);
	String randomAnswer = eightBall.randomAnswer();

	String question = questionEditText.getText().toString();
	Log.d(getClass().toString(), "The question asked was" + question);

	Intent intent = new Intent(this, AnswerActivity.class);
	intent.putExtra("randomAnswer", randomAnswer); //<-- added line

	startActivity(intent);	
}
  
```


So we have now passed the value from our EightBall to our AnswerActivity, but how do we access this value and use it in our AnswerActivity activity?


First of all, we have to get the intent passed into the activity. We can do this by calling ```getIntent()``` on AnswerActivity in ```onCreate()```. So we can save this to an ```Intent``` object i.e.:

```java
//AnswerActivity.java

    Intent intent = getIntent();
```

We then have to get the extras for the intent. We can get these by calling ```getExtras()``` on the intent object we have just created. ```getExtras()``` returns a ```Bundle``` object, so we can save this in an object i.e.:

```java
//AnswerActivity.java

    Bundle extras = intent.getExtras();
```

Finally, we can get the string for the key, by calling ```getString(<key>)``` on ```extras```. This will get the string value for the extra matching the key "name".

NOTE: we are calling getString() but the function called depends on the type being searched for e.g. boolean, int etc.

So to get the answer we would write:

```java
//AnswerActivity.java

    String randomAnswer = extras.getString("randomAnswer");
```

We can now set the text in the control, using the value in ```randomAnswer```. Plus we need to use `findViewById` to get a reference to the TextView. This time we're not setting an instance variable, just creating a local variable for this method.

```java
//AnswerActivity.java

    answerTextView.setText(randomAnswer);
```

So our ```onCreate()``` should look something like this:

```java
//AnswerActivity.java

public class AnswerActivity extends AppCompatActivity {
    
    	private TextView answerTextView; 

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d("EightBall:", "AnswerActivity.onCreateCalled");
            setContentView(R.layout.activity_answer);
	    
	    answerTextView = findViewById(R.id.answerTextView);
            
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            String randomAnswer = extras.getString("randomAnswer");
            
            answerTextView.setText(randomAnswer);
        }
    }
```

Now run the app and see what happens.

### Recap

We've seen how we can -

- Create a new Activity
- Move to a new Activity with `startActivity(Intent intent)`
- That `startActivity` requires an Intent -
	- To tell the ActivityManager what Activity to create and load
	- In this Intent we can `putExtras(String key, value)` - data to send to the new Activity
- In the destination Activity we can -
	-  `getExtras()` from the passed Intent
	-  Get a particular (typed extra) from the Budle of extras with `extras.getString(String key)` etc..

- Use whatever we got from our Intent to update our new Activity as we see fit! 

