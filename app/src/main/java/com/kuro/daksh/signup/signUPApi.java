package com.kuro.daksh.signup;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface signUPApi {
    @POST("signup")
    Call<User> createAccount(@Body RequestBody user);
}
