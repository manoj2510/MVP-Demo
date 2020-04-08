package com.example.mvpapp.network;

import com.example.mvpapp.model.signuprequest.SignUpRequest;
import com.example.mvpapp.model.signupresponse.SignUpResponse;
import com.example.mvpapp.model.userlistreponse.UserListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("/retrofit/register.php")
    Call<SignUpResponse> signUp(@Body SignUpRequest signUpRequest);

    @GET("/retrofit/getuser.php")
    Call<List<UserListResponse>> getUserList();

}
