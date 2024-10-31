package com.example.belajar;
import retrofit2.Call;
import com.example.belajar.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );
    @GET("getData.php")
    Call<UserResponse> getData(@Query("token") String token);


}
