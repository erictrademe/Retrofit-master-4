package com.indrap.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mycomputer on 19/10/16.
 */

public interface UserApi {
    @GET("/users")
    Call<Users> getUsers();

    @GET("/users{id}")
    Call<User> getUser(@Path("id") String user_id);


}
