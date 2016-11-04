package com.indrap.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ericzhong on 5/11/16.
 */

public interface IGithubEvent {
    @GET("/events")
    Call<GithubEvent> getGitEvents();
}



