package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.vinicius.jokesapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by vinicius on 26/04/17.
 */

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.OnJokeReceivedListener, Void, String>
{
	private static MyApi myApiService = null;
	private OnJokeReceivedListener listener;

	public interface OnJokeReceivedListener {

		void onReceived(String joke);
	}

	@Override
	protected String doInBackground(OnJokeReceivedListener... params)
	{
		if(myApiService == null) {  // Only do this once
			MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
					  // options for running against local devappserver
					  // - 10.0.3.2 is localhost's IP address in Android emulator
					  // - turn off compression when running against local devappserver
					  .setRootUrl("http://10.0.3.2:8080/_ah/api/")
					  .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
						  @Override
						  public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
							  abstractGoogleClientRequest.setDisableGZipContent(true);
						  }
					  });;

			myApiService = builder.build();
		}

		listener = params[0];

		try {
			return myApiService.getJoke().execute().getData();
		} catch (IOException e) {
			return e.getMessage();
		}
	}

	@Override
	protected void onPostExecute(String result)
	{
		listener.onReceived(result);
	}
}
