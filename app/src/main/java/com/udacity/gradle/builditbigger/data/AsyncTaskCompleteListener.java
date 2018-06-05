package com.udacity.gradle.builditbigger.data;

/**
 * Created by Steven on 5/06/2018.
 */

public interface AsyncTaskCompleteListener<T> {

    void onTaskComplete(T result);

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
