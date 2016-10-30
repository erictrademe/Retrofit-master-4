package com.indrap.retrofit;

import android.content.Context;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    private MainActivity activity;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);





    public ExampleInstrumentedTest()
    {


    }


   @Test
    public void testGetCurrentWeatherReturnsExpected() {

       activity = activityRule.getActivity();

       String jsonBody = asset(activity, "UserResponse.json");


        stubFor(get(urlMatching(".*/users"))
                .atPriority(1)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBodyFile(jsonBody)));


       onView(withId(R.id.button2)).perform(click());
       onView(withId(R.id.button2)).perform(click());

   }






    public static String asset(Context context, String assetPath) {
        try {
            StringBuilder buf = new StringBuilder();
            InputStream inputStream = context.getAssets().open("body_files/" + assetPath);
            return inputStreamToString(inputStream, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static final int BUFFER_SIZE = 4 * 1024;

    public static String inputStreamToString(InputStream inputStream, String charsetName)
            throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(inputStream, charsetName);
        char[] buffer = new char[BUFFER_SIZE];
        int length;
        while ((length = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, length);
        }
        return builder.toString();
    }




}
