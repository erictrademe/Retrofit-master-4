package com.indrap.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ericzhong on 5/11/16.
 */

public class GithubEvent {

    @SerializedName("id")
    String id;
    @SerializedName("type")
    String type;
    @SerializedName("created_at")
    String created_at;

}


