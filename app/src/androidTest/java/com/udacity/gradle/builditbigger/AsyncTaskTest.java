package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.udacity.gradle.builditbigger.data.AsyncTaskCompleteListener;
import com.udacity.gradle.builditbigger.data.EndpointAsyncTask;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

/**
 * Created by Steven on 4/06/2018.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testAsyncTaskJokeLoading(){
        Log.d("TEST", "START TEST");
        final CountDownLatch signal = new CountDownLatch(1);

        EndpointAsyncTask task = new EndpointAsyncTask(new AsyncTaskCompleteListener<String>() {
            @Override
            public void onTaskComplete(String result) {
                signal.countDown();
            }

            @Override
            public void showLoadingIndicator() {

            }

            @Override
            public void hideLoadingIndicator() {

            }
        });
        task.execute();
        try {
            String joke = task.get();
            assertThat(joke, not(isEmptyOrNullString()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
