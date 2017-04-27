package com.example.showjokeslibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokesActivity extends AppCompatActivity
{
	public static String JOKE_KEY = "Joke key";
	private TextView joketextView;
	private String joke = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_jokes);

		joketextView = (TextView) findViewById(R.id.jokeTextview);

		if(savedInstanceState == null)
		{
			Intent intent = getIntent();
			joke = intent.getStringExtra(JOKE_KEY);
		}

		if(joke != null)
		{
			joketextView.setText(joke);
		}
	}
}
