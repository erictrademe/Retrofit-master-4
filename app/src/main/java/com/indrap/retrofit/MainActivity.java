package com.indrap.retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv_respond, tv_result_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        Button button = (Button) findViewById(R.id.button2
        );

        button.setOnClickListener(new View.OnClickListener()
        {


            public void onClick(View v)
            {





              tv_respond = (TextView) findViewById(R.id.tv_respond);

                tv_result_api = (TextView) findViewById(R.id.tv_result_api);

                Gson gson = new GsonBuilder()

                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

                        .create();


                Retrofit retrofit = new Retrofit.Builder()

                        .baseUrl("http://127.0.0.1:8080")
                        //.baseUrl("http://private-fdf858-users180.apiary-mock.com")
                        //.baseUrl("https://api.github.com")

                        .addConverterFactory(GsonConverterFactory.create(gson))

                        .build();

                //Retrofit retrofit = new Retrofit.Builder();

                UserApi user_api = retrofit.create(UserApi.class);

                // // implement interface for get all user

                Call<Users> call = user_api.getUsers();

                call.enqueue(new Callback<Users>() {

                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        int status = response.code();


                        tv_respond.setText(String.valueOf(status));

                        //this extract data from retrofit with for() loop

                        for (Users.UserItem user : response.body().users) {

                            //tv_result_api.clearComposingText();
                            tv_result_api.setText(

                                    "Id = " + String.valueOf(user.getId()) +

                                            System.getProperty("line.separator") +

                                            "Email = " + user.getEmail() +

                                            System.getProperty("line.separator") +

                                            "Password = " + user.getPassword() +

                                            System.getProperty("line.separator")

                            );

                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                        tv_respond.setText(String.valueOf(t));
                    }
                });







      /*          GithubApi github_api = retrofit.create(GithubApi.class);

                // // implement interface for get all user

                Call<Githubuser> call = github_api.getGithubUser();

                call.enqueue(new Callback<Githubuser>() {

                    @Override
                    public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                        int status = response.code();


                        tv_respond.setText(String.valueOf(status));

                        //this extract data from retrofit with for() loop

                            tv_result_api.setText(

                                    "Id = " + response.body().id);


                    }

                    @Override
                    public void onFailure(Call<Githubuser> call, Throwable t) {

                        tv_respond.setText(String.valueOf(t));
                    }
                });*/
            }
        });


        //Retrofit and GSON implement


    }
}
