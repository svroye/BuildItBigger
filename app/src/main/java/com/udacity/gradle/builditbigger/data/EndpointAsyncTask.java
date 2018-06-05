package com.udacity.gradle.builditbigger.data;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.jokedisplayer.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Steven on 5/06/2018.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;
    private AsyncTaskCompleteListener<String> listener;

    public EndpointAsyncTask(AsyncTaskCompleteListener<String> listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.showLoadingIndicator();
    }

    @Override
    protected String doInBackground(Void... v) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        String joke = null;
        try {
            joke =  myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            e.getMessage();
        }
        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        listener.hideLoadingIndicator();
        if (result != null) {
            listener.onTaskComplete(result);
        }
    }
}