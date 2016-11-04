package com.indrap.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ezhong on 10/31/16.
 */

public interface GithubApi {
    @GET("/users/erictrademe")
    Call<Githubuser> getGithubUsers();
}
